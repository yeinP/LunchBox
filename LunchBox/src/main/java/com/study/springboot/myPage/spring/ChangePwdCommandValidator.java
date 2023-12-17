package com.study.springboot.myPage.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePwdCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ChangePwdCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPasswordConfirm", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
	}

}
