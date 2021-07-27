package com.study.reviews;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.study.contents.ContentsDTO;
import com.study.utility.Utility;

@Controller
public class ReviewsController {

	@Autowired
	@Qualifier("com.study.reviews.ReviewsServiceImpl")
	private ReviewsService service;


	@GetMapping(value = "/reviews/getCategory", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Map> getCategory(HttpServletRequest request) {
		List<Map> list = service.getCategory();

		return list;
	}


	@RequestMapping("/reviews/list")
	public String list(HttpServletRequest request) {
		// 검색관련------------------------
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));

		if (col.equals("total")) {
			word = "";
		}

		// 페이지관련-----------------------
		int nowPage = 1;// 현재 보고있는 페이지
		if (request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		int recordPerPage = 5;// 한페이지당 보여줄 레코드갯수

		// DB에서 가져올 순번-----------------
		int sno = ((nowPage - 1) * recordPerPage) + 1;
		int eno = nowPage * recordPerPage;

		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);

		int total = service.total(map);

		List<ReviewsDTO> list = service.list(map);

		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

		// request에 Model사용 결과 담는다
		request.setAttribute("list", list);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("paging", paging);

		return "/reviews/list";

	}

	@PostMapping("/reviews/create")
	public String create(ReviewsDTO dto, HttpServletRequest request) throws IOException {
		
		dto.setContentsno(Integer.parseInt(String.valueOf(service.findContentsno(dto).get("CONTENTSNO"))));
		dto.setFilename(service.findContentsno(dto).get("FILENAME"));
		
		
		
		if (service.create(dto) > 0) {
			return "redirect:./list";
		} else {
			return "error";
		}
	}
	
	
	@GetMapping("/reviews/create")
	public String create() {
		
		
		return "/reviews/create";
	}
	
	@GetMapping(value = "/reviews/getOption", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Map> getOption(HttpServletRequest request) {
		List<Map> list = service.getOption();

		return list;
	}
	
	
	@GetMapping("/reviews/read")
	public String read(int reviewno, Model model, HttpServletRequest request) {

		service.upViewcnt(reviewno);

		ReviewsDTO dto = service.read(reviewno);

		String content = dto.getRevcontent().replaceAll("\r\n", "<br>");

		dto.setRevcontent(content);

		model.addAttribute("dto", dto);

		/* 댓글 관련 시작 */
        int nPage = 1;
        if (request.getParameter("nPage") != null) {
                nPage = Integer.parseInt(request.getParameter("nPage"));
        }
        int recordPerPage = 3;

        int sno = ((nPage - 1) * recordPerPage) + 1;
        int eno = nPage * recordPerPage;

        Map map = new HashMap();
        map.put("sno", sno);
        map.put("eno", eno);
        map.put("nPage", nPage);

        model.addAllAttributes(map);

		/* 댓글 처리 끝 */

		return "/reviews/read";
	}
	
	@PostMapping("/reviews/update")
	public String update(ReviewsDTO dto) {
		int cnt = service.update(dto);

		if (cnt == 1) {
			return "redirect:./list";
		} else {
			return "error";
		}
	}

	@GetMapping("/reviews/update/{reviewno}")
	public String update(@PathVariable("reviewno") int reviewno, Model model, ReviewsDTO dto, HttpServletRequest request) {
		
		dto = service.read(reviewno);
		dto.setPname(service.findPname(reviewno).get("PNAME"));
		dto.setContentsno(Integer.parseInt(String.valueOf(service.findContentsno(dto).get("CONTENTSNO"))));
		dto.setFilename(service.findContentsno(dto).get("FILENAME"));
		
		System.out.println(dto.toString());
		model.addAttribute("dto", dto);

		return "/reviews/update";

	}
	
	@PostMapping("/reviews/delete")
	public String delete(int reviewno, String revpass, HttpServletRequest request) throws IOException {
		System.out.println(reviewno);
		System.out.println(revpass);
		
		Map map = new HashMap();
		map.put("reviewno", reviewno);
		map.put("revpass", revpass);
		int cnt = service.passCheck(map);
		
		String url = "/reviews/passwdError";

		if (cnt > 0) {

			try {
				//rmapper.bdelete(bbsno);//댓글 삭제
				//mapper.delete(bbsno);//게시글 삭제
				service.delete(reviewno);
				url = "redirect:./list";
			} catch (Exception e) {
				e.printStackTrace();
				url = "./error";
			}

		}

		return url;
	}

	@GetMapping("/reviews/delete/{reviewno}")
	public String delete(@PathVariable int reviewno, Model model) {
		System.out.println("reviewno: "+reviewno);
		int cnt = service.checkRefnum(reviewno);

		boolean flag = false;
		if (cnt > 0)
			flag = true;

		model.addAttribute("flag", flag);
		model.addAttribute("reviewno", reviewno);
		return "/reviews/delete";
	}


}