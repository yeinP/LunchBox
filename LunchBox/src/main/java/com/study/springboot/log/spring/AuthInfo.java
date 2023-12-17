package com.study.springboot.log.spring;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthInfo {

	private String memId;
	private String memEmail;
	private String memName;

}
