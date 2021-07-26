package com.study.order;

import java.util.List;

import com.study.contents.ContentsDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
	
	private int cartno;
	private String id;
	private int quantity;
	private int price;
	private int orderstate;
	
	List<ContentsDTO> contents;
}
