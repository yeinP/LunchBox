package com.study.springboot.register.spring;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder

public class MemType {
	private int memTypeNo;
	private String memTypeName;
}
