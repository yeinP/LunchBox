package com.study.springboot.shop.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.shop.cart.dtodao.CartDao;
import com.study.springboot.shop.order.dtodao.OrderDao;

@Service
public class InsertOrderService {

	
	@Autowired
	private OrderDao orderDao;
	
	
	public int insertOrder(String memId) {
		int orderNo = orderDao.insertOrder(memId);
		return orderNo;
	}
	
	public void updateOrderTotalPrice(int orderNo, int orderTotalPrice) {
		orderDao.update(orderNo, orderTotalPrice);
	}
}
