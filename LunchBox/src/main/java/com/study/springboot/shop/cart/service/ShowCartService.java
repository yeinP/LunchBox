package com.study.springboot.shop.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.shop.cart.dtodao.Cart;
import com.study.springboot.shop.cart.dtodao.CartDao;

@Service
public class ShowCartService {

	@Autowired
	private CartDao cartDao;
	
	
	public List<Cart> cartList(int cartNo){
		return cartDao.list(cartNo);
	}
}
