package com.study.springboot.register.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.log.spring.MemberDao;
import com.study.springboot.register.service.MemberRegisterService;
import com.study.springboot.register.spring.DuplicateMemberException;

import com.study.springboot.register.spring.RegisterRequest;
import com.study.springboot.shop.cart.service.CreateCartService;



@Controller
public class RegisterController {
	@Autowired
	private MemberRegisterService memberRegisterService;

	@Autowired
	private CreateCartService createCartService;
	
	@Autowired
	private MemberDao memberDao;

	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@GetMapping("/register/step2")
	public String handleStep2Get() {
		
		return "redirect:/register/step1";
	}
	
	
	@PostMapping("/register/step2")
	public String handleStep2(@ModelAttribute("registerRequest")RegisterRequest regReq, @RequestParam(value = "agree1", defaultValue = "false") Boolean agree,
			@RequestParam(value = "agree2", defaultValue = "false") Boolean agree2,
			Model model) {
		if (!agree || !agree2) {
			return "register/step1";
		}
		model.addAttribute("memTypeNoList", memberDao.selectMemTypeNo());
		//model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	
		

	@PostMapping("/register/step3")
	public String handleStep3(@Valid RegisterRequest regReq, Errors errors, Model model) {
		//new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors()) {
			model.addAttribute("memTypeNoList", memberDao.selectMemTypeNo());
			return "register/step2";
		}
		try {
			memberRegisterService.regist(regReq);
			createCartService.createCart(regReq);
		
			return "/main";
		} catch (DuplicateMemberException ex) {
			model.addAttribute("memTypeNoList", memberDao.selectMemTypeNo());
			errors.rejectValue("memId", "duplicate");
			errors.rejectValue("memEmail", "duplicate");
			return "register/step2";
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new RegisterRequestValidator());
	}

}
