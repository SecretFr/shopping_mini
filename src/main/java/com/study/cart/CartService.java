package com.study.cart;



public interface CartService {

	int create(CartDTO cartDto);
	
	int createOrderCart(OrderCartDTO dto);
//	CartDTO create();

}
