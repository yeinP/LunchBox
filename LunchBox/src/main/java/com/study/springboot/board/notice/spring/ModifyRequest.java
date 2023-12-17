package com.study.springboot.board.notice.spring;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ModifyRequest {

	private int articleNo;
	private String articleTitle;
	private String articleContent;
	
//	public void validate(Map<String, Boolean> errors) {
//		if (articleTitle == null || articleTitle.trim().isEmpty()) {
//			errors.put("title", Boolean.TRUE);
//		}
//	}
	
}
