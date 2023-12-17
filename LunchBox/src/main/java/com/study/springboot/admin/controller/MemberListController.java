package com.study.springboot.admin.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.admin.model.ListCommand;
import com.study.springboot.admin.model.OrderList;
import com.study.springboot.admin.model.SearchInfoDto;
import com.study.springboot.admin.service.AdminService;
import com.study.springboot.admin.service.searchService;
import com.study.springboot.admin.spring.MemberList;
import com.study.springboot.board.notice.spring.NoticeArticlePage;
import com.study.springboot.board.proposal.spring.Article;
import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.log.spring.Member;
import com.study.springboot.log.spring.MemberDao;

@Controller
@RequestMapping("/admin")
public class MemberListController {
	
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private AdminService adminservice;
	
	@Autowired
	private searchService searchService;
	
	@GetMapping ("/memberList")
	public String memberList( Model model, @RequestParam(value = "pageNo", required = false) String pageNoVal) {
		int pageNo = 1; 
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		MemberList memberList = adminservice.getMemberList(pageNo);
		
		model.addAttribute("memberList", memberList);
		return "admin/memberList";
	}	
	
	@GetMapping("/memberOrderInfo/{memId}")
	public String memberOrderInfo(Model model, @PathVariable String memId) {
		model.addAttribute("memberOrderInfo", memberDao.memberOrderInfo(memId));
		return "admin/memberOrderInfo";
	}
	
	
//	@GetMapping("/orderList")
//	public String orderList(@ModelAttribute("cmd") ListCommand listCommand, Errors errors, Model model) {
//		System.out.println(listCommand);
//		if (errors.hasErrors()) {
//			System.out.println("에러");
//			return "admin/orderList";
//		}
//
//		if(listCommand.getFrom() != null && listCommand.getTo() != null) {
//			List<OrderList> orderList = memberDao.selectByOrder(listCommand.getFrom(), listCommand.getTo());
//			model.addAttribute("orderList", orderList);
//			}
//		return "admin/orderList";
//	}
	
	@GetMapping("/orderList")
	public String orderList(Model model) {
		return "admin/orderList";
	} 
	
	@GetMapping("/infoSearch")
	public void orderSearch (Model model,  String keyword, String startDate, String endDate, HttpSession session ) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");	
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate oneWeekAgoDate = currentDate.minusWeeks(1);
//        startDate = oneWeekAgoDate.format(formatter);
//		endDate = currentDate.format(formatter);
		if (keyword.equals("")) {
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
			List<OrderList> list = searchService.searchDate(startDate, endDate);
			model.addAttribute("orderList", list);
			model.addAttribute("authInfo", authInfo);
		} else {
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
			model.addAttribute("keyword", keyword);
			List<OrderList> list = searchService.searchDateKeyword(startDate, endDate, keyword);
			model.addAttribute("orderList", list);model.addAttribute("authInfo", authInfo);
		}
	}
	
	@GetMapping("/subSearch2")
	public void subSearch (Model model,  String keyword, String searchDate, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");	
		if (keyword.equals("")) {
			model.addAttribute("searchDate", searchDate);
			List<OrderList> list = searchService.searchSubDate(searchDate);
			model.addAttribute("list", list);
			model.addAttribute("authInfo", authInfo);
		} else {
			model.addAttribute("searchDate", searchDate);
			model.addAttribute("keyword", keyword);
			List<OrderList> list = searchService.searchSubDateKeyword(searchDate, keyword);
			model.addAttribute("list", list);
			model.addAttribute("authInfo", authInfo);
		}
	}
}

