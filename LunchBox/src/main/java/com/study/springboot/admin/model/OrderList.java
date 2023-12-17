package com.study.springboot.admin.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@AllArgsConstructor
@Setter
public class OrderList {
	private String memId;
	private LocalDateTime orderDate;
	private int productNo;
	private String productName;
	private int productPrice;

}
