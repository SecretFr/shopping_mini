package com.study.order;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class OrderDTO {
	private String orderno;
	private String cartno;
	
	private String zipcode;
	private String address1;
	private String address2;
	private String payment;
	private LocalDate odate;	
	
}
