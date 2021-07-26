package com.study.cart;

import java.util.List;
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
import com.study.order.CartAndContentsDTO;
import com.study.cart.CartDTO;
import com.study.order.OrderMapper;

@Controller
public class CartController {

	 	@Autowired
	    @Qualifier("com.study.cart.CartServiceImpl")
	    private CartService service;
	 	
	 	@Autowired
	 	private OrderMapper orderMapper;
	 
		@PostMapping("/cart/create")
		public String update( @RequestParam Map<String,String> map, Model model, HttpSession session) {
			String id = (String) session.getAttribute("id");

			if (id == null) {
				return "redirect:/member/login";
			} 

		    model.addAttribute("pname", map.get("pname"));
		    model.addAttribute("contentsno", map.get("contentsno"));
		    model.addAttribute("price", map.get("price"));
		    model.addAttribute("detail", map.get("detail"));
		    model.addAttribute("stock", map.get("stock"));
		    
//		    System.out.println("pname: "+map.get("pname"));
//		    System.out.println("no: "+map.get("contentsno"));
//		    System.out.println("price: "+map.get("price"));
//		    System.out.println("detail: "+map.get("detail"));
//		    System.out.println("stock: "+map.get("stock"));


		    CartDTO cartDto = new CartDTO();
		    cartDto.setId(id);
		    cartDto.setPrice(Integer.parseInt(map.get("price")));
		    
		    
//		    System.out.println("contentsno : " + contentsno);
//		    System.out.println("============================");
		    //카트 테이블에 등록하는 로직 구현 
		   System.out.println("id: "+cartDto.getId());
		   System.out.println("price : "+cartDto.getPrice());
		    
		    //CartDTO dto2 = service.create();
		  //  return "redirect:/cart/list";
			if (service.create(cartDto) > 0) {
				OrderCartDTO orderCartDto = new OrderCartDTO();
			    orderCartDto.setContentsno(Integer.parseInt(map.get("contentsno")));
			    service.createOrderCart(orderCartDto);
		
				return "redirect:/cart/list";
			} else {
				return "error";
			}
		}
	 
	 

		
    @GetMapping("/cart/list")
    public String read(Model model, HttpSession session) {
            
    	String id = (String) session.getAttribute("id");

		if (id == null) {
			return "redirect:/member/login";
		}
		
		CartDTO cartDto = new CartDTO();
		cartDto.setId(id);
		cartDto.setCartno(6);
		cartDto.setOrderstate(0);
		
		List<CartAndContentsDTO> cartAndContents = orderMapper.getContents(cartDto);
		model.addAttribute("cartlist", cartAndContents);

		
        return "/cart/list";
    }
	
}
//cart/list