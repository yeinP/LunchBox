package com.study.springboot.board.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.board.notice.spring.ModifyRequest;
import com.study.springboot.board.notice.spring.NoticeArticlePage;
import com.study.springboot.board.notice.spring.NoticeDao;
import com.study.springboot.board.notice.spring.WriteRequest;
import com.study.springboot.board.proposal.spring.Article;
import com.study.springboot.board.proposal.spring.ArticleDao;
import com.study.springboot.log.spring.AuthInfo;
@Service
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
	public void noticeDelete(int articleNO) {
		noticeDao.delete(articleNO);
	}
	
	
	public NoticeArticlePage getNoticeArticlePage(int pageNum) {
		int size = 5;
		int total = noticeDao.noticeCount();
		List<Article> content = noticeDao.noticeSelect((pageNum - 1) * size, size);
		return new NoticeArticlePage(total, pageNum, size, content);
	}
	
	public void noticeModify(ModifyRequest modReq) {			
		Article modArticle = new Article(modReq.getArticleNo(), modReq.getArticleTitle(), modReq.getArticleContent(), 0, null, null,0);
		noticeDao.updateNotice(modArticle);
	}
	

	public Article getArticle(int articleNo, boolean  increasearticleHits) {
		Article article = noticeDao.selectByNoticeNo(articleNo);
		if (increasearticleHits) {
			noticeDao.increaseReadCount(articleNo);
		}
		return new Article(article.getArticleNo(),article.getArticleTitle(), article.getArticleContent(), article.getArticleHits(), article.getArticleRegDate(), article.getMemId(), article.getArticleTypeNo());
	}
	
	public Integer noticeInsert(WriteRequest writeRequest, AuthInfo authInfo) {	
		Article newNoticeArticle = new Article(0, writeRequest.getArticleTitle(), writeRequest.getArticleContent(), 0, null, authInfo.getMemId(), 111);
		Article article = noticeDao.insert(newNoticeArticle);
		return article.getArticleNo();
		
	}
}
