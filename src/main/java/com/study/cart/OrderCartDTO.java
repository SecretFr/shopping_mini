package com.study.cart;

import lombok.Data;

@Data
public class OrderCartDTO {

	private int contents_cart_no;
	private int contentsno;
	private int cartno;

	public OrderCartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderCartDTO(int contents_cart_no, int contentsno, int cartno) {
		super();
		this.contents_cart_no = contents_cart_no;
		this.contentsno = contentsno;
		this.cartno = cartno;
	}

	@Override
	public String toString() {
		return "OrderCartDTO [contents_cart_no=" + contents_cart_no + ", contentsno=" + contentsno + ", cartno="
				+ cartno + "]";
	}

	public int getContents_cart_no() {
		return contents_cart_no;
	}

	public void setContents_cart_no(int contents_cart_no) {
		this.contents_cart_no = contents_cart_no;
	}

	public int getContentsno() {
		return contentsno;
	}

	public void setContentsno(int contentsno) {
		this.contentsno = contentsno;
	}

	public int getCartno() {
		return cartno;
	}

	public void setCartno(int cartno) {
		this.cartno = cartno;
	}

}
