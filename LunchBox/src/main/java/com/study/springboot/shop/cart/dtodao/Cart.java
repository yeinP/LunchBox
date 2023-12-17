package com.study.springboot.shop.cart.dtodao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Cart {
	
	//cart 테이블
	private int cartNo;
	//cart, cart_detail 테이블
	private String memId;
	
	// cart_datail 테이블
	private int cartDetailNo;
	private int productNo;
	private String productName;
	private int productPrice;
	private int cartAmount;
	private int price;
}
