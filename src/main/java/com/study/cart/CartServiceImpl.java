package com.study.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.contents.ContentsMapper;
import com.study.member.MemberDTO;

@Service("com.study.cart.CartServiceImpl")
public class CartServiceImpl implements CartService {
	  @Autowired
	  private CartMapper mapper;

	@Override
	public int create(CartDTO dto) {
		// TODO Auto-generated method stub
		return mapper.create(dto);
	}

	@Override
	public int createOrderCart(OrderCartDTO dto) {
		// TODO Auto-generated method stub
		return mapper.createOrderCart(dto);
	}

	@Override
	public int getCartno() {
		// TODO Auto-generated method stub
		return mapper.getCartno();
	}

	@Override
	public int hasCart(String id) {
		// TODO Auto-generated method stub
		return mapper.hasCart(id);
	}
	


}
