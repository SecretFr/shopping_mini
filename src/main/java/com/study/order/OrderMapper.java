package com.study.order;

import java.util.List;

import com.study.cart.CartDTO;

public interface OrderMapper {

	List<CartAndContentsDTO> getOrders(CartDTO cartDto);
	
	List<CartAndContentsDTO> getContents(CartDTO cartDto);
	
	int createOrder(OrderDTO orderDto);
	
	int updateCart(String id);
	
	// TODO
	// int updateStock(int cartno);
}
