package com.study.springboot.shop.order.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.shop.cart.dtodao.Cart;
import com.study.springboot.shop.cart.dtodao.CartDao;
import com.study.springboot.shop.cart.service.ShowCartService;
import com.study.springboot.shop.order.service.InsertOrderDetailService;
import com.study.springboot.shop.order.service.InsertOrderService;
import com.study.springboot.shop.order.service.ListOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ShowCartService showCartService;
	
	@Autowired
	private ListOrderService listOrderService;
	
	@Autowired
	private InsertOrderService insertOrderService;
	
	@Autowired
	private InsertOrderDetailService insertOrderDetailService;
	
	
		@GetMapping
		public String order() {
			return "shop/order/orderPage";
		}
		
		
		@PostMapping("/orderNow")
		public String orderNow(Model model, HttpSession session, HttpServletRequest request) {
			
			
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			Integer cartNo = cartDao.selectCartNo(authInfo.getMemId());
			
			
			ArrayList<Cart> list = new ArrayList<>();
			String[] productNos = request.getParameterValues("checkedProduct");	
			
			for(int i = 0; i < productNos.length; i++) {
				Integer productNo = Integer.parseInt(productNos[i]);
				list.add(listOrderService.list(cartNo, productNo));
			}
			model.addAttribute("checkedProducts",list);

			return "shop/order/orderNow";
		}
		
		@GetMapping("/subPage")
		public String subPage() {
			return "shop/subscribe/subPage";
		}
		
		@PostMapping("/subNow")
		public String subNow(Model model, HttpSession session, HttpServletRequest request) {
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			return "shop/order/subNow";
		}
		
		

		//여기부터 주문 목록을 위한 코드 
		@PostMapping("/payment")
		public String payment(@RequestParam int orderTotalPrice, HttpServletRequest request, HttpSession session) {
			
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			//주문테이블에 회원 아이디 삽입하고 주문 번호 받아옴
			int orderNo = insertOrderService.insertOrder(authInfo.getMemId());
			insertOrderService.updateOrderTotalPrice(orderNo, orderTotalPrice);
			
			String[] productNos = request.getParameterValues("checkedProducts");
			for(int i = 0; i < productNos.length; i++) {
				Integer productNo = Integer.parseInt(productNos[i]);
				insertOrderDetailService.insertOrderDetail(orderNo, productNo ,authInfo);
			}
			cartDao.deleteAll();
			return "/main";
		}
}
