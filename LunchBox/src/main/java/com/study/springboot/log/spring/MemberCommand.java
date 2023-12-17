package com.study.springboot.log.spring;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCommand {

	
	private String memId;
	@Size(min=6)
	private String memPassword;
	@NotEmpty
	private String memPasswordConfirm;
	@NotEmpty
	private String memName;
	@NotBlank
	@Email
	private String memEmail;
	private String memPhone;
	private String memAddress;
	private boolean ynMgr;
	
	
	
	
	
	

	public boolean isPasswordEqualToConfirmPassword() {
		return memPassword.equals(memPasswordConfirm);
	}
}
