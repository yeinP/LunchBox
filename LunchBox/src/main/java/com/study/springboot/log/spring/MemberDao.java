package com.study.springboot.log.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.study.springboot.admin.model.MemberOrder;
import com.study.springboot.admin.model.OrderList;
import com.study.springboot.register.spring.MemType;

import lombok.RequiredArgsConstructor;


@Repository
public class MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(Member member) {
		String sql = "insert into member(memId, memPassword, memName, memEmail, memPhone, memAddress, memRegDate, memTypeNo)"
				+ "values(?,?,?,?,?,?,now(),?)";
		
		this.jdbcTemplate.update(sql, member.getMemId(), member.getMemPassword(), member.getMemName(), member.getMemEmail(), member.getMemPhone(), member.getMemAddress(), member.getMemTypeNo());	
	}

	

	public Member selectByMemId(String memId) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where memId = ?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("memId"),
								rs.getString("memPassword"),
								rs.getString("memName"),
								rs.getString("memEmail"),
								rs.getString("memPhone"),
								rs.getString("memAddress"),
								rs.getTimestamp("memRegDate").toLocalDateTime(),
								rs.getInt("memTypeNo"));
						return member;
					}
				}, memId);

		return results.isEmpty() ? null : results.get(0);
	}
	//예인
	public int memberCount() {
		String sql = "select count(*) from member where memTypeNo = 99";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public List<Member> listMember(int startRow, int  size){
		String sql = "select * from member order by memName desc limit ?, ?";
		return jdbcTemplate.query(sql, (rs, n) -> {
			Member member = new Member(
			rs.getString("memId"),
			rs.getString("memPassword"),
			rs.getString("memName"),
			rs.getString("memEmail"),
			rs.getString("memPhone"),
			rs.getString("memAddress"),
			rs.getTimestamp("memRegDate").toLocalDateTime(),
			rs.getInt("memTypeNo"));
			return member;
		},startRow, size);
	}
	
	
	private RowMapper<Member> memRowMapper = (rs, n) -> {
		Member member = new Member(rs.getString("memId"), 
				rs.getString("memPassword"), 
				rs.getString("memName"),
				rs.getString("memEmail"),
				rs.getString("memPhone"),
				rs.getString("memAddress"),
				rs.getTimestamp("memRegDate").toLocalDateTime(),
				rs.getInt("memTypeNo"));
		return member;
	};
	
	public Member selectById(String memId) {
		String sql = "select * from member where memId = ?";
		List<Member> results = this.jdbcTemplate.query(sql, memRowMapper, memId);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<MemberOrder> memberOrderInfo(String memId) {
		String sql = "SELECT m.memId, p.productName, p.productPrice, o.orderDate, o.orderNo, o.orderTotalPrice, od.orderAmount "
		        + "FROM member m "
		        + "INNER JOIN orderr o ON m.memId = o.memId "
		        + "INNER JOIN order_detail od ON o.orderNo = od.orderNo "
		        + "INNER JOIN product p ON od.productNo = p.productNo "
		        + "WHERE m.memId = ? ORDER BY o.orderNo";

		List<MemberOrder> results = this.jdbcTemplate.query(sql,(rs, n) -> {
			MemberOrder memberOrder = new MemberOrder(
			rs.getString("memId"), 
			rs.getString("productName"),
			rs.getInt("productPrice"),
			rs.getTimestamp("orderDate").toLocalDateTime(),
			rs.getInt("orderNo"),
			rs.getInt("orderTotalPrice"),
			rs.getInt("orderAmount"));
			return memberOrder;
		}, memId);
		return results;
	}

	public Member selectByEmail(String memEmail) {
		String sql = "select * from member where memEmail = ?";
		List<Member> results = this.jdbcTemplate.query(sql, memRowMapper, memEmail);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<MemType> selectMemTypeNo() {
		String sql = "select * from mem_type";
		return this.jdbcTemplate.query(sql, (rs, n)-> {
			MemType memType = MemType.builder()
					.memTypeNo(rs.getInt("memTypeNo"))
					.memTypeName(rs.getString("memTypeName")).build();
			return memType;
		});
	}

	
	public List<Member> selectByRegdate(LocalDate from, LocalDate to){
		String sql = "select * from Member where memRegDate between ? and ? order by memRegDate desc";
		List<Member> results = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("memId"),
						rs.getString("memPassword"), 
						rs.getString("memName"),
						rs.getString("memEmail"),
						rs.getString("memPhone"),
						rs.getString("memAddress"),
						rs.getTimestamp("memRegDate").toLocalDateTime(),
						rs.getInt("memTypeNo"));
				member.setMemId(rs.getString("memId"));					
				return member;
			}
			
		}, from, to);
				return results;
		
	}
	
	public List<OrderList> selectByOrder(LocalDate from, LocalDate to){
		String sql = "SELECT o.memId, o.orderDate, od.productNo, p.productName, o.orderTotalPrice" + 
	            " from orderr o inner join order_detail od on(o.orderNo=od.orderNo) inner join product p on ( od.productNo = p.productNo) where orderDate between ?  and ? order by orderDate, memId";
		List<OrderList> results = jdbcTemplate.query(sql, new RowMapper<OrderList>() {

			@Override
			public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderList orderList = new OrderList(
						rs.getString("memId"),
						rs.getTimestamp("orderDate").toLocalDateTime(), 
						rs.getInt("productNo"),
						rs.getString("productName"),
						rs.getInt("orderTotalPrice"));
				orderList.setMemId(rs.getString("memId"));					
				return orderList;
			}
			
		}, from, to);
		return results;
	}

	

	
	

	public void update(Member member) {
		jdbcTemplate.update(
				"update member set memPassword=?, memEmail=?, memPhone=?, memAddress= ? where memId = ?",
				member.getMemPassword(), member.getMemEmail(), member.getMemPhone(), member.getMemAddress(), member.getMemId());
	}



	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}
	
	public List<MemberOrder> UserOrderInfo(String memId) {
		String sql = "SELECT m.memId, p.productName, p.productPrice, o.orderDate, o.orderNo, o.orderTotalPrice, od.orderAmount "
		        + "FROM member m "
		        + "INNER JOIN orderr o ON m.memId = o.memId "
		        + "INNER JOIN order_detail od ON o.orderNo = od.orderNo "
		        + "INNER JOIN product p ON od.productNo = p.productNo "
		        + "WHERE m.memId = ? ORDER BY o.orderNo";

		List<MemberOrder> results = this.jdbcTemplate.query(sql,(rs, n) -> {
			MemberOrder memberOrder = new MemberOrder(
			rs.getString("memId"), 
			rs.getString("productName"),
			rs.getInt("productPrice"),
			rs.getTimestamp("orderDate").toLocalDateTime(),
			rs.getInt("orderNo"),
			rs.getInt("orderTotalPrice"),
			rs.getInt("orderAmount"));
			return memberOrder;
		}, memId);
		return results;
	}

}
