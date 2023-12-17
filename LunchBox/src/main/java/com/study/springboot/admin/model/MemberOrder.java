package com.study.springboot.admin.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberOrder {
	private String memId;
	private String productName;
	private int productPrice;
	private LocalDateTime orderDate;
	private int orderNo;
	private int orderTotalPrice;
	private int orderAmount;
	
}
