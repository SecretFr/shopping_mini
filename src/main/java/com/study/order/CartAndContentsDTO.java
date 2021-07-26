package com.study.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartAndContentsDTO {
	private int cartno;
	private String id;
	private int quantity;
	private int price;
	private int orderstate;
	private int contentsno;
	private String pname;
	private int contentsPrice;
	private String detail;
}
