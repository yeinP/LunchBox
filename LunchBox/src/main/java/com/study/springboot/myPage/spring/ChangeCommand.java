package com.study.springboot.myPage.spring;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeCommand {
	
	@NotBlank
	private String newPhone;
	@NotBlank
	@Email
	private String newEmail;
	@NotBlank
	private String newAddress;
}
