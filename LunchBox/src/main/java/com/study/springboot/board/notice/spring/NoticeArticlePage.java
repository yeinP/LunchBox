package com.study.springboot.board.notice.spring;

import java.util.List;

import com.study.springboot.board.proposal.spring.Article;

import lombok.Getter;

@Getter
public class NoticeArticlePage {
	private int total;
	private int currentPage;
	private List<Article> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public NoticeArticlePage(int total, int currentPage, int size, List<Article> content) {
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
