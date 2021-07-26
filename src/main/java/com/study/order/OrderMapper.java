package com.study.order;

import java.util.List;

public interface OrderMapper {

	//cartMapper
	List<CartAndContentsDTO> getContents(CartDTO cartDto);
}
