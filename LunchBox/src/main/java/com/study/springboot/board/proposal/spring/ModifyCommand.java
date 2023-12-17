package com.study.springboot.board.proposal.spring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyCommand {
	private String articleTitle;
	private String articleContent;
	private int articleNo;
}
