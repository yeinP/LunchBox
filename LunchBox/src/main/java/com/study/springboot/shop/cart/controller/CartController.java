package com.study.springboot.shop.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.shop.cart.dtodao.CartDao;
import com.study.springboot.shop.cart.service.DeleteCartService;
import com.study.springboot.shop.cart.service.InsertCartDetailService;
import com.study.springboot.shop.cart.service.ShowCartService;
import com.study.springboot.shop.product.ProductCommand;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private InsertCartDetailService insertCartDetailService;
	
	@Autowired
	private DeleteCartService deleteCartService;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ShowCartService showCartService;

	//내 장바구니 보기
	@GetMapping("/myCart")
	public String myCart(Model model, HttpSession session) {
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		Integer cartNo = cartDao.selectCartNo(authInfo.getMemId());
		model.addAttribute("showCart",showCartService.cartList(cartNo));
		System.out.println(showCartService.cartList(cartNo));
		return "shop/cart/myCart";
	}
	
	//장바구니에 추가
	@PostMapping("/myCart")
	public String myCartPost(ProductCommand productCommand, Model model, HttpSession session) {
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		insertCartDetailService.insertCartDetail(productCommand, authInfo);
		Integer cartNo = cartDao.selectCartNo(authInfo.getMemId());
		model.addAttribute("showCart",showCartService.cartList(cartNo));
		System.out.println(showCartService.cartList(cartNo));
		return "shop/cart/myCart";
	}
	
	//장바구니에서 선택 삭제
	@PostMapping("/delete")
	public String deleteCart(HttpSession session, HttpServletRequest request) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String[] productNos = request.getParameterValues("checkedProduct");
		
		for(int i = 0; i < productNos.length; i++) {
			Integer productNo = Integer.parseInt(productNos[i]);
			deleteCartService.deleteCartDetail(productNo, authInfo);
			
		}
		
		return "redirect:/cart/myCart";
	}
}
