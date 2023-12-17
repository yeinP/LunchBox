package com.study.springboot.board.notice.spring;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.study.springboot.board.proposal.spring.Article;
@Repository
public class NoticeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Article> articleRowMapper = (rs, n) -> {
		Article article = new Article(
				rs.getInt("articleNo"),
				rs.getString("articleTitle"),
				rs.getString("articleContent"),
				rs.getInt("articleHits"),
				rs.getTimestamp("articleregdate").toLocalDateTime(),
				rs.getString("memId"),
				rs.getInt("articleTypeNo"));
		return article;
	};
	
	
	public int noticeCount() {
		String sql = "select count(*) from article where articleTypeNo=111";
		return jdbcTemplate.queryForObject(sql, Integer.class);	
	}
	
	public List<Article> noticeSelect(int startRow, int size) {
		String sql = "select * from article where articleTypeNo = 111 order by articleNo desc limit ?, ?";
		return jdbcTemplate.query(sql, articleRowMapper, startRow, size);		
	}
	
	public Article selectByNoticeNo(int articleNo) {
		String sql = "select * from article where articleNo = ?";
		List<Article> list = jdbcTemplate.query(sql, articleRowMapper, articleNo);
		return list.isEmpty() ? null: list.get(0);
	}
	
	public Article noticeInsert(Article article) {
		String sql = "insert into article(articleNo, articleTitle, articleContent, articleHits, articleRegDate, memId, articleTypeNo)"
				+ "values(?,?,?,0,now(),?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update((con) -> {
			PreparedStatement pstm 
			  = con.prepareStatement(sql, new String[] {"articleNo"});
			pstm.setString(1, article.getArticleTitle());
			pstm.setString(2, article.getArticleContent());
			pstm.setString(3, article.getMemId());
			pstm.setInt(4, article.getArticleTypeNo());
			return pstm;
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		article.setArticleNo(keyValue.intValue());
		return article;
		
	}
	
	public void delete(int articleNo) {
		String sql = "delete from article where articleNo = ?";
		jdbcTemplate.update(sql,articleNo);
		
	}
	
	public void increaseReadCount(int articleNo) {
		String sql = "update article set articleHits = articleHits + 1 "+
				"where articleNo = ?";
		jdbcTemplate.update(sql, articleNo);
	}


	
	public void updateNotice(Article article) {
		String sql = "update article set articleTitle=? , articleContent=?, articleRegDate = now()"
				+ " where articleNo = ?";
		jdbcTemplate.update(sql, article.getArticleTitle(), article.getArticleContent(), article.getArticleNo());
	}
	
	public void deleteNotice(int articleNo) {
		String sql = "delete from article where articleNo = ?";
		jdbcTemplate.update(sql,articleNo);
		
	}
	
	public Article insert(Article article) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into article(articleNo, articleTitle, articleContent"
				+ ", articleHits, articleRegDate, memId, articleTypeNo) values (0,?,?,0,now(),?,?)";
		jdbcTemplate.update((con)->{
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"article_no"});
			pstmt.setString(1, article.getArticleTitle());
			pstmt.setString(2, article.getArticleContent());
			pstmt.setString(3, article.getMemId());
			pstmt.setInt(4, article.getArticleTypeNo());
			return pstmt;
		}, keyHolder);
		Integer keyVlaue = keyHolder.getKey().intValue();
		article.setArticleNo(keyVlaue);
		return article;
	}
	

}
