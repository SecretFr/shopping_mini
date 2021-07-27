package com.study.cart;

public interface CartMapper {

	int create(CartDTO dto);
	
	int createOrderCart(OrderCartDTO dto);

	int getCartno();
	
	int hasCart(String id);

	void delete(int cartno);

	void deleteCCN(int contentscartno);

	int getCartCount(int cartno);
}
