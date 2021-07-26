package com.study.orders;

public class OrdersDTO {
	private int orderno;
	private int cartno;
	private int contentsno;
	private String odate;
	private int quantity;
	private int total;
	@Override
	public String toString() {
		return "OrdersDTO [orderno=" + orderno + ", cartno=" + cartno + ", contentsno=" + contentsno + ", odate="
				+ odate + ", quantity=" + quantity + ", total=" + total + ", payment=" + payment + ", id=" + id
				+ ", mname=" + mname + ", pname=" + pname + "]";
	}
	public OrdersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdersDTO(int orderno, int cartno, int contentsno, String odate, int quantity, int total, String payment,
			String id, String mname, String pname) {
		super();
		this.orderno = orderno;
		this.cartno = cartno;
		this.contentsno = contentsno;
		this.odate = odate;
		this.quantity = quantity;
		this.total = total;
		this.payment = payment;
		this.id = id;
		this.mname = mname;
		this.pname = pname;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getContentsno() {
		return contentsno;
	}
	public void setContentsno(int contentsno) {
		this.contentsno = contentsno;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	private String payment;
	private String id;
	private String mname;
	private String pname;
}
