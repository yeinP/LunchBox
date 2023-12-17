package com.study.springboot.board.review.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.board.notice.spring.ModifyRequest;
import com.study.springboot.board.notice.spring.WriteRequest;
import com.study.springboot.board.proposal.spring.Article;
import com.study.springboot.board.proposal.spring.ArticleDao;
import com.study.springboot.board.review.spring.ReviewArticlePage;
import com.study.springboot.board.review.spring.ReviewDao;
import com.study.springboot.log.spring.AuthInfo;


@Service
public class ReviewService {
	@Autowired
	private ReviewDao reviewDao;
	
	public Article getArticle(int articleNo, boolean  increasearticleHits) {
		Article article = reviewDao.selectByReviewNo(articleNo);
		if (increasearticleHits) {
			reviewDao.increaseReadCount1(articleNo);
		}
		return new Article(article.getArticleNo(),article.getArticleTitle(), article.getArticleContent(), article.getArticleHits(), article.getArticleRegDate(), article.getMemId(), article.getArticleTypeNo());
	}
	
	
	public void reviewDelete(int articleNO) {
		reviewDao.deleteReview(articleNO);
	}
		
	public Integer reviewInsert(WriteRequest writeRequest, AuthInfo authInfo) {	
		Article newReviewArticle = new Article(0, writeRequest.getArticleTitle(), writeRequest.getArticleContent(), 0, null, authInfo.getMemId(), 222);
		Article article = reviewDao.reviewInsert(newReviewArticle);
		return article.getArticleNo();	
	}
		
	public void reviewModify(ModifyRequest modReq) {			
		Article modArticle = new Article(modReq.getArticleNo(), modReq.getArticleTitle(), modReq.getArticleContent(), 0, null, null,0);
		reviewDao.updateReview(modArticle);
	}
	
	public ReviewArticlePage getReviewArticlePage(int pageNum) {
		int size = 20;
		int total = reviewDao.reviewCount();
		List<Article> content = reviewDao.reviewSelect((pageNum - 1) * size, size);
		return new ReviewArticlePage(total, pageNum, size, content);
	}


}
