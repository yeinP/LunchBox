package com.study.springboot.shop.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.shop.cart.dtodao.CartCommand;
import com.study.springboot.shop.cart.dtodao.CartDao;
import com.study.springboot.shop.product.ProductCommand;

@Service
public class DeleteCartService {
	
	@Autowired
	private CartDao cartDao;
	
	public void deleteCartDetail(Integer productNo, AuthInfo authInfo) {

		Integer cartNo = cartDao.selectCartNo(authInfo.getMemId());
		cartDao.selectCartDetailNo(cartNo, productNo);
		cartDao.delete(cartDao.selectCartDetailNo(cartNo, productNo));
		
	}
}
