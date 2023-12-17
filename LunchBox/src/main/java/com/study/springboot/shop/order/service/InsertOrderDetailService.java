package com.study.springboot.shop.order.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.shop.cart.dtodao.Cart;
import com.study.springboot.shop.cart.dtodao.CartDao;
import com.study.springboot.shop.order.dtodao.Order;
import com.study.springboot.shop.order.dtodao.OrderDao;

@Service
public class InsertOrderDetailService {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public void insertOrderDetail(int orderNo, int productNo , AuthInfo authInfo) {
		
		Integer cartNo = cartDao.selectCartNo(authInfo.getMemId());
		Cart cart = cartDao.checkedList(cartNo, productNo);
		
		Order order = new Order(orderNo, authInfo.getMemId(), 0, null, 0, cart.getProductNo(), cart.getCartAmount(),null,null);
		 if (productNo == 4) {
		        order.setSubStartDate(Timestamp.valueOf(LocalDateTime.now()));
		        order.setSubEndDate(Timestamp.valueOf(LocalDateTime.now().plusDays(7)));
		    } else if (productNo == 5) {
		        order.setSubStartDate(Timestamp.valueOf(LocalDateTime.now()));
		        order.setSubEndDate(Timestamp.valueOf(LocalDateTime.now().plusDays(14)));
		    } else if (productNo == 6) {
		        order.setSubStartDate(Timestamp.valueOf(LocalDateTime.now()));
		        order.setSubEndDate(Timestamp.valueOf(LocalDateTime.now().plusMonths(1)));
		    }
		orderDao.insertOrderDetail(order);
		
	}
}
