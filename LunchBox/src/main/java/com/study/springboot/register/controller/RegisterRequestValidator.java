package com.study.springboot.register.controller;


import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.study.springboot.register.spring.RegisterRequest;

public class RegisterRequestValidator implements Validator {
//	private static final String emailRegExp = 
//			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
//			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//	private Pattern pattern;
//
//	public RegisterRequestValidator() {
//		pattern = Pattern.compile(emailRegExp);
//
//	}

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		//커멘드객체
		RegisterRequest regReq = (RegisterRequest) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memEmail", "required");
		
		ValidationUtils.rejectIfEmpty(errors, "memPassword", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		if (!regReq.getMemPassword().isEmpty()) {
			if (!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
		
	}

}
