package com.study.springboot.board.proposal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.board.proposal.spring.Article;
import com.study.springboot.board.proposal.spring.ArticleCommand;
import com.study.springboot.board.proposal.spring.ArticleDao;
import com.study.springboot.board.proposal.spring.ArticlePage;
import com.study.springboot.board.proposal.spring.ModifyCommand;
import com.study.springboot.log.spring.AuthInfo;

@Service
public class ProposalService {
	@Autowired
	private ArticleDao articleDao;
	
	public void deleteArticle(int articleNo) {
		articleDao.delete(articleNo);
	}
	
	public Article readArticle(int articleNo) {
		int articleHits = articleDao.selectOne(articleNo).getArticleHits();
		articleDao.plusHits(articleHits, articleNo);
		return articleDao.selectOne(articleNo);
	}
	public List<Article> list111Article() {
		return articleDao.selectArticle(111);
	}


//후기 게시판 글 보기
	public List<Article> list222Article() {
		return articleDao.selectArticle(222);
	}


	//건의 게시판 글 보기
	public List<Article> listProposalArticle() {
		return articleDao.selectArticle(333);
	}



	//건의 게시판 페이지 처리 (게시물 분류 333)

	public ArticlePage getArticlePage(int pageNo) {
		int size = 5;
		int total = articleDao.count333();
		List<Article> content = articleDao.select((pageNo*size)-size, size);
		return new ArticlePage(total, pageNo, size, content);
	}
	
	public void updateArticle(ModifyCommand modifyCommand) {
		
		System.out.println(modifyCommand.getArticleNo());
		System.out.println(modifyCommand.getArticleTitle());
		System.out.println(modifyCommand.getArticleContent());
		
		Article article = new Article(modifyCommand.getArticleNo(), modifyCommand.getArticleTitle(), modifyCommand.getArticleContent(), 0, null, null,0);
		
		articleDao.update(article);
	}
	
	public Integer insertProposalArticle(ArticleCommand articleCommand, AuthInfo authInfo) {
		Article ProPosalarticle = new Article(0, articleCommand.getArticleTitle(), articleCommand.getArticleContent(), 0, null, authInfo.getMemId(), 333);
		Article article = articleDao.insert(ProPosalarticle);
		return article.getArticleNo();
		
	}
}
