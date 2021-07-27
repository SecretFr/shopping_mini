package com.study.cart;



public interface CartService {

	int create(CartDTO cartDto);
	
	int createOrderCart(OrderCartDTO dto);
	
	int getCartno();
	
	int hasCart(String id);
//	CartDTO create();

	void delete(int cartno);

	void deleteCCN(int contentscartno);

	int getCartCount(int cartno);

}
