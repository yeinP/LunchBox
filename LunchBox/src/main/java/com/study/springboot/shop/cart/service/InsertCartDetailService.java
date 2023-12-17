package com.study.springboot.shop.cart.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.shop.cart.dtodao.CartCommand;
import com.study.springboot.shop.cart.dtodao.CartDao;
import com.study.springboot.shop.product.ProductCommand;

@Service
public class InsertCartDetailService {
	
	@Autowired
	private CartDao cartDao;
	
	public void insertCartDetail(ProductCommand productCommand, AuthInfo authInfo) {

		Integer cartNo = cartDao.selectCartNo(authInfo.getMemId());
		if(productCommand.getBasicAmount()!=0) {
			if(cartDao.selectCartDetailNo(cartNo, productCommand.getBasic())!=0) {
				cartDao.update(cartDao.selectCartDetailNo(cartNo, productCommand.getBasic()), productCommand.getBasicAmount());
			} else {
			CartCommand cartCommand = new CartCommand(cartNo, productCommand.getBasic(), productCommand.getBasicAmount());
			cartDao.insertCartDetail(cartCommand);
			}
		}
		if(productCommand.getGoodMealAmount()!=0) {
			if(cartDao.selectCartDetailNo(cartNo, productCommand.getGoodMeal())!=0) {
				cartDao.update(cartDao.selectCartDetailNo(cartNo, productCommand.getGoodMeal()), productCommand.getGoodMealAmount());
			} else {
			CartCommand cartCommand = new CartCommand(cartNo, productCommand.getGoodMeal(), productCommand.getGoodMealAmount());
			cartDao.insertCartDetail(cartCommand);
			}
		}
		if(productCommand.getHappyAmount()!=0) {
			if(cartDao.selectCartDetailNo(cartNo, productCommand.getHappy())!=0) {
				cartDao.update(cartDao.selectCartDetailNo(cartNo, productCommand.getHappy()), productCommand.getHappyAmount());
			} else {
			CartCommand cartCommand = new CartCommand(cartNo, productCommand.getHappy(), productCommand.getHappyAmount());
			cartDao.insertCartDetail(cartCommand);
			}
		}
		if(productCommand.getOneAmount()!=0) {
			if(cartDao.selectCartDetailNo(cartNo, productCommand.getOne())!=0) {
				cartDao.update(cartDao.selectCartDetailNo(cartNo, productCommand.getOne()), productCommand.getOneAmount());
			} else {
			CartCommand cartCommand = new CartCommand(cartNo, productCommand.getOne(), productCommand.getOneAmount());
			cartDao.insertCartDetail(cartCommand);
			}
		}
		if(productCommand.getTwoAmount()!=0) {
			if(cartDao.selectCartDetailNo(cartNo, productCommand.getTwo())!=0) {
				cartDao.update(cartDao.selectCartDetailNo(cartNo, productCommand.getTwo()), productCommand.getTwoAmount());
			} else {
			CartCommand cartCommand = new CartCommand(cartNo, productCommand.getTwo(), productCommand.getTwoAmount());
			cartDao.insertCartDetail(cartCommand);
			}
		}
		if(productCommand.getMonthAmount()!=0) {
			if(cartDao.selectCartDetailNo(cartNo, productCommand.getMonth())!=0) {
				cartDao.update(cartDao.selectCartDetailNo(cartNo, productCommand.getMonth()), productCommand.getMonthAmount());
			} else {
			CartCommand cartCommand = new CartCommand(cartNo, productCommand.getMonth(), productCommand.getMonthAmount());
			cartDao.insertCartDetail(cartCommand);
			}
		}
			
		
		
	}
}
