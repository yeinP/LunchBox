package com.study.springboot.shop.order.dtodao;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {

	
	private int orderNo;
	private String memId;
	private int orderTotalPrice;
	private LocalDateTime orderDate;
	//	
	private int orderDetailNo;
	private int productNo;
	private int orderAmount;
	private Timestamp subStartDate;
	private Timestamp subEndDate;
	
}
