package com.study.order;

import java.util.List;

import com.study.cart.CartDTO;

public interface OrderMapper {

	//cartMapper
	List<CartAndContentsDTO> getOrders(CartDTO cartDto);
	
	List<CartAndContentsDTO> getContents(CartDTO cartDto);
	
	int createOrder(OrderDTO orderDto);
	
	int updateCart(int cartno);
}
