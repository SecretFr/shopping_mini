package com.study.cart;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.contents.ContentsDTO;
import com.study.order.CartAndContentsDTO;
import com.study.cart.CartDTO;
import com.study.order.OrderMapper;

@Controller
public class CartController {

		final int BEFORE_ORDER = 0;
		final int AFTER_ORDER = 1;
	
	 	@Autowired
	    @Qualifier("com.study.cart.CartServiceImpl")
	    private CartService service;
	 	
	 	@Autowired
	 	private OrderMapper orderMapper;
	 
	 	@GetMapping("/cart/delete/{cartno}/{contentsCartNo}")
	 	public String delete(@PathVariable("cartno") int cartno, @PathVariable("contentsCartNo") int contentscartno, HttpServletRequest request, Model model){
	 		
	 		
//			ContentsDTO dto =service.read(contentsno);
//			model.addAttribute("dto",dto);
//			return "/contents/read";
	 		
	 		//ordercart에 있는 cartnumber 개수 구함.
	 		int totalcartcount = service.getCartCount(cartno);
	 		
	 		
	 		if(totalcartcount > 1) {
	 			
	 			service.deleteCCN(contentscartno);

	 		}else {
	 			
	 			service.deleteCCN(contentscartno);
		 		service.delete(cartno);
		 		
	 			
	 		}
	 		
	 		return "redirect:/cart/list";
	 	}
	 	
	 	

		
	 	
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
		    model.addAttribute("quantity", map.get("quantity"));
		    
//		    System.out.println("pname: "+map.get("pname"));
//		    System.out.println("no: "+map.get("contentsno"));
//		    System.out.println("price: "+map.get("price"));
//		    System.out.println("detail: "+map.get("detail"));
//		    System.out.println("stock: "+map.get("stock"));


		    CartDTO cartDto = new CartDTO();
		    cartDto.setOrderstate(BEFORE_ORDER);
		    cartDto.setId(id);
		    
		    
//		    System.out.println("contentsno : " + contentsno);
//		    System.out.println("============================");
		    //카트 테이블에 등록하는 로직 구현 
		   System.out.println("id: "+cartDto.getId());
		   System.out.println("price : "+cartDto.getPrice());
		    
		    //CartDTO dto2 = service.create();
		  //  return "redirect:/cart/list";
//		   select id = cart orderstate = 0 있는지
//				  있다면  cart create X, orderCart에만 해당 cartno create
//				  없다면 cart create
			int hasCart = service.hasCart(id);
		    if(hasCart > 0) {
		    	OrderCartDTO orderCartDto = new OrderCartDTO();
		    	orderCartDto.setCartno(service.getCartno());
			    orderCartDto.setContentsno(Integer.parseInt(map.get("contentsno")));
			    orderCartDto.setQuantity(Integer.parseInt(map.get("quantity")));
			    service.createOrderCart(orderCartDto);
			    model.addAttribute("cartno", service.getCartno());
			    System.out.println(service.getCartno());
			    return "redirect:/cart/list";
		    }else {
				if (service.create(cartDto) > 0) {
					OrderCartDTO orderCartDto = new OrderCartDTO();
				    orderCartDto.setContentsno(Integer.parseInt(map.get("contentsno")));
				    orderCartDto.setQuantity(Integer.parseInt(map.get("quantity")));
				    service.createOrderCart(orderCartDto);
				    model.addAttribute("cartno", service.getCartno());
				    System.out.println(service.getCartno());
					return "redirect:/cart/list";
				}
		    }
	
			return "error";
			
		}
	 
	 

		
    @GetMapping("/cart/list")
    public String read(Model model, HttpSession session) {
            
    	String id = (String) session.getAttribute("id");

		if (id == null) {
			return "redirect:/member/login";
		}
		
		CartDTO cartDto = new CartDTO();
		cartDto.setId(id);
		//cartDto.setCartno(6);
		cartDto.setOrderstate(BEFORE_ORDER);
		
		List<CartAndContentsDTO> cartAndContents = orderMapper.getContents(cartDto);
		if(cartAndContents.size() <= 0) {
			return "/cart/list";
		}
		for(CartAndContentsDTO dto : cartAndContents) {
			dto.setSum(dto.getPrice() * dto.getQuantity());
		}
		model.addAttribute("cartlist", cartAndContents);
		model.addAttribute("cartno", cartAndContents.get(0).getCartno());
		
        return "/cart/list";
    }
	
}
//cart/list