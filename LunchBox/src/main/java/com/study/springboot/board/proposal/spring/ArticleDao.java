package com.study.springboot.board.proposal.spring;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class ArticleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//게시글 목록 가져오기(111,222,333에 해당하는 목록을 가져온다)
	public List<Article> selectArticle(int articleTypeNo){
		String sql = "select articleNo, articleTitle, articleContent"
				+ ", articleHits, articleRegDate, memId, articleTypeNo"
				+ " from article where articleTypeNo = ? order by articleNo desc";
		List<Article> list = jdbcTemplate.query(sql, (rs,n)->{
			Article article = new Article(
					rs.getInt("articleNo"),
					rs.getString("articleTitle"),
					rs.getString("articleContent"),
					rs.getInt("articleHits"),
					rs.getTimestamp("articleRegDate").toLocalDateTime(),
					rs.getString("memId"),
					rs.getInt("articleTypeNo"));
					return article;
		}, articleTypeNo);
		return list;
	}
	
	
	public Article selectOne(int articleNo) {
		String sql = "select articleNo, articleTitle, articleContent"
				+ ", articleHits, articleRegDate, memId, articleTypeNo"
				+ " from article where articleNo = ?";
		return jdbcTemplate.queryForObject(sql, (rs,n)->{
			Article article = new Article(
					rs.getInt("articleNo"),
					rs.getString("articleTitle"),
					rs.getString("articleContent"),
					rs.getInt("articleHits"),
					rs.getTimestamp("articleRegDate").toLocalDateTime(),
					rs.getString("memId"),
					rs.getInt("articleTypeNo"));
					return article;
		}, articleNo);
	}
	
	//조회수 올리기
	public void plusHits(int articleHits, int articleNo) {
		String sql = "update article set articleHits= ? where articleNo = ?";
		jdbcTemplate.update(sql, articleHits+1, articleNo);
	}
	
	
	
	
	//게시글 등록
	public void insertArticle(Article article) {
		String sql = "insert into article(articleNo, articleTitle, articleContent"
				+ ", articleHits, articleRegDate, memId, articleTypeNo) values (0,?,?,0,now(),?,?)";
		jdbcTemplate.update(sql, article.getArticleTitle(), article.getArticleContent(), article.getMemId(), article.getArticleTypeNo());
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
	
	public void update(Article article) {
		String sql = "update article set articleTitle=? , articleContent=?, articleRegDate = now()"
				+ " where articleNo = ?";
		
		System.out.println(article.getArticleNo());
		jdbcTemplate.update(sql, article.getArticleTitle(), article.getArticleContent(), article.getArticleNo());
	}
	
	// 게시글 삭제
	public void delete(int articleNo) {
		String sql = "delete from article where articleNo = ?";
		jdbcTemplate.update(sql,articleNo);
		
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from article", Integer.class);
		return count;
	}
	
	// 페이지 처리를 위해서 건의 게시물 개수만 뽑는 메소드
	public int count333() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from article where articleTypeNo=333", Integer.class);
		return count;
	}
	
	
	
	//페이지 처리에 필요한 애
	public List<Article> select(int startRow, int size) {
		String sql = "select * from article order by articleNo desc limit ?, ?";  // 스타트부터 size 개의 데이터
		return  jdbcTemplate.query(sql, (rs,n)->{
			Article article = new Article(
					rs.getInt("articleNo"),
					rs.getString("articleTitle"),
					rs.getString("articleContent"),
					rs.getInt("articleHits"),
					rs.getTimestamp("articleRegDate").toLocalDateTime(),
					rs.getString("memId"),
					rs.getInt("articleTypeNo"));
			return article;
		}, startRow, size);
	}
		
		
	}

