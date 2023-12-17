package com.study.springboot.shop.order.dtodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public int insertOrder(String memId) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into orderr (orderNo, memId, orderTotalPrice, orderDate)"
				+" values(0, ?, 0, now())";
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"orderNo"});
				pstmt.setString(1, memId);
				return pstmt;
			}
		}, keyHolder);
		int keyValue = keyHolder.getKey().intValue();
		return keyValue;
	}
	
	public void insertOrderDetail(Order order) {
		String sql = "insert into order_detail(orderDetailNo, orderNo, productNo, orderAmount, subStrtDate, subEndDate)"
				+" values(0, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, order.getOrderNo(), order.getProductNo(), order.getOrderAmount(), order.getSubStartDate(), order.getSubEndDate());
	}

	public void update(int orderNo, int orderTotalPrice) {
		String sql = "update orderr set orderTotalPrice=? where orderNo = ?";
		jdbcTemplate.update(sql, orderTotalPrice, orderNo);
	}
		
	
}
