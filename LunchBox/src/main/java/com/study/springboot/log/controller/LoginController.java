package com.study.springboot.log.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.log.service.AuthService;
import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.log.spring.LoginCommand;
import com.study.springboot.log.spring.MemberSession;
import com.study.springboot.log.spring.WrongIdPasswordException;
import com.study.springboot.myPage.service.MyPageSessionService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private AuthService authService;
	@Autowired
	private MyPageSessionService myPageSessionService;
	
    @GetMapping
    public String form(LoginCommand loginCommand,
    		@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			loginCommand.setMemId(rCookie.getValue());
			loginCommand.setRememberId(true);
		}
    	return "login/loginForm2";
    }

    @PostMapping
    public String submit(@RequestParam String id,@RequestParam String password,
    		LoginCommand loginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
//        if (errors.hasErrors()) {
//            return "login/loginForm";
//        }
    	
    	loginCommand.setMemId(id);
    	loginCommand.setMemPassword(password);
        try {
            AuthInfo authInfo = authService.authenticate(
                    loginCommand.getMemId(),
                    loginCommand.getMemPassword());
            MemberSession memberSession = myPageSessionService.getSession(loginCommand.getMemId());
            
            
            session.setAttribute("authInfo", authInfo);
            session.setAttribute("memberSession",memberSession);
            
			Cookie rememberCookie = 
					new Cookie("REMEMBER", loginCommand.getMemId());
			rememberCookie.setPath("/");
			if (loginCommand.isRememberId()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);

            return "main";
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm2";
        }
    }
}
