package com.study.springboot.register.spring;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter


public class RegisterRequest {
	@NotBlank
	private String memId; 
	@NotBlank
	private String memPassword;  
	@NotBlank
	private String confirmPassword;
	@NotBlank
	private String memName; 
	@NotBlank
	private String memEmail; 
	private String memPhone; 
	private String memAddress; 
	private int memTypeNo;
	
	public boolean isPasswordEqualToConfirmPassword() {
		return memPassword.equals(confirmPassword);
	}
}
