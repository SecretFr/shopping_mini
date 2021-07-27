package com.study.order;

import java.util.List;

import com.study.cart.CartDTO;
import com.study.member.MemberDTO;

public interface OrderService {
	List<CartAndContentsDTO> getOrders(CartDTO cartDto);

	List<CartAndContentsDTO> getContents(CartDTO cartDto);

	int createOrder(OrderDTO orderDto);

	int updateCart(String id);

}
