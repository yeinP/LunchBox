package com.study.springboot.log.spring;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Member {

	@NotNull
	private String memId;
	@NotNull
	private String memPassword;
	@NotNull
	private String memName;
	@NotNull
	private String memEmail;
	private String memPhone;
	private String memAddress;
	private LocalDateTime memRegDate;
	@NotNull
	private int memTypeNo;
	
	public void setMemId(String memId) {
		this.memId = memId;
	}
	

	public void changePassword(String oldPassword, String newPassword) {
		if (!memPassword.equals(oldPassword)) {
			throw new WrongIdPasswordException();
		}
		this.memPassword = newPassword;
	}

	public void changeEmail(String newEmail) {
		this.memEmail = newEmail;
	}
	public void changePhone(String newPhone) {
		this.memPhone = newPhone;
	}
	public void changeAddress(String newAddress) {
		this.memAddress = newAddress;
	}
	
	public boolean matchPassword(String password) {
		return this.memPassword.equals(password);
	}
}
