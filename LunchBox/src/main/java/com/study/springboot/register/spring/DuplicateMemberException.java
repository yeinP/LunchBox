package com.study.springboot.register.spring;

public class DuplicateMemberException extends RuntimeException {

	public DuplicateMemberException(String message) {
		super(message);
	}

}
