package com.study.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.cart.CartDTO;
import com.study.member.MemberMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping
public class OrderController {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	// private final BasketMapper basketMapper;
	
	
	//주문 목록 조회
	@GetMapping("/member/mypage")
	public String getOrder(HttpSession session, Model model) {
		// 해당 장바구니 번호와 연결된 콘텐츠, 수량, 가격을 전부 가져온다.
		String id = (String) session.getAttribute("id");

		if (id == null) {
			return "redirect:/member/login";
		} 
		// 장바구니라 1:1 이기에 cartno 필요 없을 듯 하다.
		//select where id = id and orderstate = 0 join contents
		CartDTO cartDto = new CartDTO();
		cartDto.setId(id);
		cartDto.setOrderstate(1);
		

		model.addAttribute("member", memberMapper.getMember(id));
		System.out.println(memberMapper.getMember(id));
		List<CartAndContentsDTO> cartAndContents = orderMapper.getOrders(cartDto);
		model.addAttribute("cartAndContents", cartAndContents);

		for(CartAndContentsDTO dto : cartAndContents) {
			System.out.println(dto);
		}
		return "/member/mypage";
		
	}
	
	
	@GetMapping("/order")
	public String getOrders(int cartno, HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		if (id == null) {
			return "redirect:/member/login";
		} 
		
		CartDTO cartDto = new CartDTO();
		cartDto.setId(id);
		cartDto.setCartno(cartno);
		cartDto.setOrderstate(0);
		
		List<CartAndContentsDTO> cartAndContents = orderMapper.getContents(cartDto);
		model.addAttribute("cartAndContents", cartAndContents);

		return "/order";
	}
	
	
	//완료시 재고 -1, price, quantity 제대로 연산
	//
	@PostMapping("/order")
	public String order(OrderDTO orderDto) {
		// int cnt = orderMapper.create(orderDto);
		// basketMapper.updateStatus(orderDto.getBasketId()); or basketMapper.delete(orderDto.getBasketId());
//		if(cnt <= 0) {
//			return "/error";
//		}
		
		return "redirect:/member/mypage";
	}
}
