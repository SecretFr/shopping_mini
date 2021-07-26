package com.study.order;

import java.util.List;

import com.study.contents.ContentsDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CartDTO {
	
	private int cartno;
	private String id;
	private int quantity;
	private int price;
	private int orderstate;
	
	List<ContentsDTO> contents;

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int cartno, String id, int quantity, int price, int orderstate, List<ContentsDTO> contents) {
		super();
		this.cartno = cartno;
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.orderstate = orderstate;
		this.contents = contents;
	}

	public int getCartno() {
		return cartno;
	}

	public void setCartno(int cartno) {
		this.cartno = cartno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}

	public List<ContentsDTO> getContents() {
		return contents;
	}

	public void setContents(List<ContentsDTO> contents) {
		this.contents = contents;
	}
	
	
}
