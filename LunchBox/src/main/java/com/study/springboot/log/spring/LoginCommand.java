package com.study.springboot.log.spring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCommand {

	private String memId;
	private String memPassword;
	private boolean rememberId;

}
