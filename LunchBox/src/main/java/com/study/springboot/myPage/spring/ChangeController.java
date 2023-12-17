package com.study.springboot.myPage.spring;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.log.spring.MemberSession;
import com.study.springboot.log.spring.WrongIdPasswordException;
import com.study.springboot.log.spring.WrongPasswordConfirmException;
import com.study.springboot.myPage.service.ChangePasswordService;

@Controller
@RequestMapping("/edit")
public class ChangeController {

	@Autowired
	private ChangePasswordService changePasswordService;

	@GetMapping("/changePassword")
	public String form(
			@ModelAttribute("command") ChangePwdCommand pwdCmd) {
		return "edit/changePwdForm";
	}

	@PostMapping("/changePassword")
	public String submit(
			@ModelAttribute("command") ChangePwdCommand pwdCmd,
			Errors errors,
			HttpSession session) {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if (errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		try {
			changePasswordService.changePassword(
					authInfo.getMemId(),
					pwdCmd.getCurrentPassword(),
					pwdCmd.getNewPassword(),
					pwdCmd.getNewPasswordConfirm());
			return "edit/changedPwd";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		} catch (WrongPasswordConfirmException e) {
			errors.rejectValue("newPasswordConfirm", "notMatching");
			return "edit/changePwdForm";
		}
	}
	
	@GetMapping("/changeInfo")
	public String changeInfo1(ChangeCommand changeCommand) {
		return "edit/changeInfoForm";
	}
	
	
	@PostMapping("/changeInfo")
	public String changeInfo2(@Valid ChangeCommand changeCommand, Errors errors, HttpSession session) {
		if(errors.hasErrors()) {
			return "edit/changeInfoForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		changePasswordService.changeInfo(authInfo.getMemId(), changeCommand);
		MemberSession myPageSession = (MemberSession)  session.getAttribute("memberSession");
		myPageSession.setMemEmail(changeCommand.getNewEmail());
		myPageSession.setMemPhone(changeCommand.getNewPhone());
		myPageSession.setMemAddress(changeCommand.getNewAddress());
		
		return "edit/changedInfo";
	}
}
