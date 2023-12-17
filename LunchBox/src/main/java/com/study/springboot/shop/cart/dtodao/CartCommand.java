package com.study.springboot.shop.cart.dtodao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartCommand {
	private Integer cartNo;
	private Integer productNo;
	private Integer productAmount;
}
