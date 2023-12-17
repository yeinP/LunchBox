package com.study.springboot.shop.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {

	private int productNo;
	private String productName;
	private int productPrice;
}
