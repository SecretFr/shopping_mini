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
	public int create(int contentsno) {
		// TODO Auto-generated method stub
		return mapper.create(contentsno);
	}


}
