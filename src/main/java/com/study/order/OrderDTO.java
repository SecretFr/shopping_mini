package com.study.order;

import java.time.LocalDate;

public class OrderDTO {
	private String orderno;
	private int cartno;

	private String zipcode;
	private String address1;
	private String address2;
	private String payment;
	private LocalDate odate;

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(String orderno, int cartno, String zipcode, String address1, String address2, String payment,
			LocalDate odate) {
		super();
		this.orderno = orderno;
		this.cartno = cartno;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.payment = payment;
		this.odate = odate;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public int getCartno() {
		return cartno;
	}

	public void setCartno(int cartno) {
		this.cartno = cartno;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public LocalDate getOdate() {
		return odate;
	}

	public void setOdate(LocalDate odate) {
		this.odate = odate;
	}
	
}
