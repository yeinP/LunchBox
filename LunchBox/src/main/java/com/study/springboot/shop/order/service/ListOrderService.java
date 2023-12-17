package com.study.springboot.shop.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.shop.cart.dtodao.Cart;
import com.study.springboot.shop.cart.dtodao.CartDao;

@Service
public class ListOrderService {

	@Autowired
	private CartDao cartDao;
	
	
	public Cart list(Integer cartNo, Integer productNo){

		return cartDao.checkedList(cartNo, productNo);
	}
}
