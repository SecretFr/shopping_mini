package com.study.cart;

public interface CartMapper {

	int create(CartDTO dto);
	
	int createOrderCart(OrderCartDTO dto);

}
