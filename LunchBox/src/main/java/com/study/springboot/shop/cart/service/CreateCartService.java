package com.study.springboot.shop.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.register.spring.RegisterRequest;
import com.study.springboot.shop.cart.dtodao.Cart;
import com.study.springboot.shop.cart.dtodao.CartDao;

@Service
public class CreateCartService {

	@Autowired
	private CartDao cartDao;
	
	public void createCart(RegisterRequest registerRequest) {
		Cart cart = new Cart(0, registerRequest.getMemId(), 0, 0, null, 0, 0, 0);
		cartDao.insert(cart);
	}
	
}
