package com.study.order;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CartAndContentsDTO {
	private LocalDate odate;
	private String payment;
	private int cartno;
	private String id;
	private int quantity;
	private int price;
	private int orderstate;
	private int contentsno;
	private String pname;
	private int contentsPrice;
	private String detail;

	public LocalDate getOdate() {
		return odate;
	}

	public void setOdate(LocalDate odate) {
		this.odate = odate;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
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

	public int getContentsno() {
		return contentsno;
	}

	public void setContentsno(int contentsno) {
		this.contentsno = contentsno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getContentsPrice() {
		return contentsPrice;
	}

	public void setContentsPrice(int contentsPrice) {
		this.contentsPrice = contentsPrice;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "CartAndContentsDTO [odate=" + odate + ", payment=" + payment + ", cartno=" + cartno + ", id=" + id
				+ ", quantity=" + quantity + ", price=" + price + ", orderstate=" + orderstate + ", contentsno="
				+ contentsno + ", pname=" + pname + ", contentsPrice=" + contentsPrice + ", detail=" + detail + "]";
	}

	public CartAndContentsDTO(LocalDate odate, String payment, int cartno, String id, int quantity, int price,
			int orderstate, int contentsno, String pname, int contentsPrice, String detail) {
		super();
		this.odate = odate;
		this.payment = payment;
		this.cartno = cartno;
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.orderstate = orderstate;
		this.contentsno = contentsno;
		this.pname = pname;
		this.contentsPrice = contentsPrice;
		this.detail = detail;
	}

	public CartAndContentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}