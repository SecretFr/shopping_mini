package com.study.cart;

import lombok.Data;

@Data
public class CartDTO {

	private int cartNo;
	private String id; 
	private int quantity;
	private int price;
	private int orderstate;
	
}
