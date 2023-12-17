package com.study.springboot.log.spring;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MemberSession {
	private String memId;
	private String memName;
	private String memEmail;
	private String memPhone;
	private String memAddress;
	private int memTypeNo;
}
