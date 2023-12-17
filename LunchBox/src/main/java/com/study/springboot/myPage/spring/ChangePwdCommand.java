package com.study.springboot.myPage.spring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePwdCommand {

	private String currentPassword;
	private String newPassword;
	private String newPasswordConfirm;

	
	public boolean isPasswordEqualToConfirmPassword() {
		return newPassword.equals(newPasswordConfirm);
	}
	
}
