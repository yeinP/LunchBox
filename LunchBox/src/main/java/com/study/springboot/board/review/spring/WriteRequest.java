package com.study.springboot.board.review.spring;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class WriteRequest {

	private String articleTitle;
	private String articleContent;
}
