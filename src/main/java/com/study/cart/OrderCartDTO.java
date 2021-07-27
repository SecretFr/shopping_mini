package com.study.cart;

public class OrderCartDTO {

	private int contents_cart_no;
	private int contentsno;
	private int cartno;
	private int quantity;

	public OrderCartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderCartDTO(int contents_cart_no, int contentsno, int cartno, int quantity) {
		super();
		this.contents_cart_no = contents_cart_no;
		this.contentsno = contentsno;
		this.cartno = cartno;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
