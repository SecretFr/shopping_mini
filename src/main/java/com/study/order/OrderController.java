package com.study.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.member.MemberMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class OrderController {

	private final OrderMapper orderMapper;
	private final MemberMapper memberMapper;
	// private final BasketMapper basketMapper;
	
	@GetMapping("/member/mypage")
	public String getOrder(HttpSession session,Model model) {
		// 해당 장바구니 번호와 연결된 콘텐츠, 수량, 가격을 전부 가져온다.
		String id = (String) session.getAttribute("id");

		if (id == null) {
			return "redirect:./login/";
		} 
		// 장바구니라 1:1 이기에 cartno 필요 없을 듯 하다.
		//select where id = id and orderstate = 0 join contents
		CartDTO cartDto = new CartDTO();
		cartDto.setId(id);
		cartDto.setOrderstate(1);
		

		model.addAttribute("member", memberMapper.getMember(id));
		System.out.println(memberMapper.getMember(id));
		List<CartAndContentsDTO> cartAndContents = orderMapper.getContents(cartDto);
		model.addAttribute("cartAndContents", cartAndContents);

		for(CartAndContentsDTO dto : cartAndContents) {
			System.out.println(dto);
		}
		return "/member/mypage";
		
	}
	
	@PostMapping("/order")
	public String order(OrderDTO orderDto) {
		// int cnt = orderMapper.create(orderDto);
		// basketMapper.updateStatus(orderDto.getBasketId()); or basketMapper.delete(orderDto.getBasketId());
//		if(cnt <= 0) {
//			return "/error";
//		}
		
		return "redirect:/orders";
	}
	
	@GetMapping("/orders")
	public String getOrders(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		// page 기능 추가 필요, 이해하고 추가하기
		// List<OrderDTO> orders = orderMapper.getOrders(id);
		// 조인한 DTO(OrderAndContent(basketId로 가져와진) 또는 orders의 basket id를 통해 갯수만큼 쿼리날린 후 모델에 담아보냄
		// contents와 수량, 가격
		// List<ContentsDTO> Contents = basketMapper.getContents(basketId);
		
		// 
		// model.addAttribute("OrderAndContents", orderAndContentsDto);
		
		return "/orders";
	}
}
