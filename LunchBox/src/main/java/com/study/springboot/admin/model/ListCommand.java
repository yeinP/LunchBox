package com.study.springboot.admin.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ListCommand {
	@DateTimeFormat(pattern ="yyyyMMdd")
	private LocalDate from;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private LocalDate to;
	
}
