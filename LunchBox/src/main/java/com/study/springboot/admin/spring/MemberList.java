package com.study.springboot.admin.spring;

import java.util.List;

import com.study.springboot.board.proposal.spring.Article;
import com.study.springboot.log.spring.Member;

import lombok.Getter;
@Getter 
public class MemberList {
	private int total;
	private int currentPage;
	private List<Member> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public MemberList(int total, int currentPage, int size, List<Member>content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if (total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;
			if (total % size > 0) {
				totalPages++;
			}
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			if (modVal == 0) startPage -= 5;
			
			endPage = startPage + 4;
			if (endPage > totalPages) endPage = totalPages;
		}
	}
	public boolean hasNoArticles() {
		return total == 0;
	}
	public boolean hasArticles() {
		return total > 0;
	}
	
		
}
