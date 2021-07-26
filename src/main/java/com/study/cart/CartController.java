package com.study.cart;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.contents.ContentsDTO;

@Controller
public class CartController {

	 @Autowired
	    @Qualifier("com.study.cart.CartServiceImpl")
	    private CartService service;
	 
		@PostMapping("/cart/create")
		public String update( @RequestParam Map<String,String> map, Model model) {

		    model.addAttribute("pname", map.get("pname"));
		    model.addAttribute("contentsno", map.get("contentsno"));
		    model.addAttribute("price", map.get("price"));
		    model.addAttribute("detail", map.get("detail"));
		    model.addAttribute("stock", map.get("stock"));


		    
	
		    int contentsno = Integer.parseInt(map.get("contentsno"));
		
		    System.out.println("contentsno : " + contentsno);
		    System.out.println("============================");
		    //카트 테이블에 등록하는 로직 구현 
		   
		    
		    //CartDTO dto2 = service.create();
		  //  return "redirect:/cart/list";
			if (service.create(contentsno) > 0) {
				return "redirect:/cart/list";
			} else {
				return "error";
			}
		}
	 
	 

		
    @GetMapping("/cart/list")
    public String read( String id, Model model, HttpSession session) {
            
            if(id == null) {
                    id = (String) session.getAttribute("id");
            }
            
           // model.addAttribute("pname",map.get("pname"));
            
            model.addAttribute("id", id);
            
            //등록된 카트테이블에서 select 해와서 뷰로 뿌르는 로직
            
            return "/cart/list";
    }
	
}
//cart/list