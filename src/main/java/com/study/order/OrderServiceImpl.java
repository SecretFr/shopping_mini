package com.study.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.study.cart.CartDTO;
import com.study.member.MemberMapper;

@Primary
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public List<CartAndContentsDTO> getOrders(CartDTO cartDto) {
		// TODO Auto-generated method stub
		return orderMapper.getOrders(cartDto);
	}

	@Override
	public List<CartAndContentsDTO> getContents(CartDTO cartDto) {
		// TODO Auto-generated method stub
		return orderMapper.getContents(cartDto);
	}

	@Override
	public int createOrder(OrderDTO orderDto) {
		// TODO Auto-generated method stub
		return orderMapper.createOrder(orderDto);
	}

	@Override
	public int updateCart(String id) {
		// TODO Auto-generated method stub
		return orderMapper.updateCart(id);
	}

}
