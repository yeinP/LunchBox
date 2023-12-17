package com.study.springboot.board.proposal.spring;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	private int articleNo;
	private String articleTitle;
	private String articleContent;
	private int articleHits;
	private LocalDateTime articleRegDate;
	private String memId;
	private int articleTypeNo;
	
}
