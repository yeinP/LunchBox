package com.study.springboot.myPage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.log.spring.MemberCommand;
import com.study.springboot.log.spring.MemberDao;
import com.study.springboot.myPage.spring.ChangePwdCommand;

@Controller
@RequestMapping("/myPage")
public class myPageController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/myInfo")
	public String myInfo(MemberCommand memberCommand, Model model, HttpSession session, @ModelAttribute("command") ChangePwdCommand pwdCmd) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");	
		model.addAttribute("userOrderInfo", memberDao.UserOrderInfo(authInfo.getMemId()));
		return "myPage/myInfo";
	}
}
