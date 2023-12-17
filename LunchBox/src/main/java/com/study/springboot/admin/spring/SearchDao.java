package com.study.springboot.admin.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.study.springboot.admin.model.OrderList;
@Repository
public class SearchDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int selectCountDate(String start, String end) {
        String sql = "SELECT COUNT(*) FROM complaint WHERE regdate BETWEEN STR_TO_DATE(?, '%Y-%m-%d') AND DATE_ADD(STR_TO_DATE(?, '%Y-%m-%d'), INTERVAL 1 DAY)";
        return jdbcTemplate.queryForObject(sql, Integer.class, start, end);
    }
	
	public List<OrderList> listByOrderDate(String start, String end){
		String sql = "SELECT o.memId, o.orderDate, od.productNo, p.productName, p.productPrice" + 
	            " from orderr o inner join order_detail od on(o.orderNo=od.orderNo) inner join product p on ( od.productNo = p.productNo) where orderDate between ?  and ? and od.productNo In(1,2,3) order by orderDate, memId";
		List<OrderList> results = jdbcTemplate.query(sql, new RowMapper<OrderList>() {

			@Override
			public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderList orderList = new OrderList(
						rs.getString("memId"),
						rs.getTimestamp("orderDate").toLocalDateTime(), 
						rs.getInt("productNo"),
						rs.getString("productName"),
						rs.getInt("productPrice"));
				orderList.setMemId(rs.getString("memId"));					
				return orderList;
			}
			
		}, start, end);
		return results;
	}
	
	public List<OrderList> selectCountDateKeyword(String start, String end, String keyword){
		String sql = "SELECT o.memId, o.orderDate, od.productNo, p.productName, p.productPrice" + 
	            " from orderr o inner join order_detail od on(o.orderNo=od.orderNo) inner join product p on ( od.productNo = p.productNo) where orderDate between ?  and ? and o.memId = ? and od.productNo In(1,2,3) order by orderDate, memId";
		List<OrderList> results = jdbcTemplate.query(sql, new RowMapper<OrderList>() {

			@Override
			public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderList orderList = new OrderList(
						rs.getString("memId"),
						rs.getTimestamp("orderDate").toLocalDateTime(), 
						rs.getInt("productNo"),
						rs.getString("productName"),
						rs.getInt("productPrice"));
				orderList.setMemId(rs.getString("memId"));					
				return orderList;
			}
			
		}, start, end, keyword);
		return results;
	}
	String todayString = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	
	public List<OrderList> listBySubDate(String subDate){
		String sql = "SELECT o.memId, o.orderDate, od.productNo, p.productName, p.productPrice" + 
	            " from orderr o inner join order_detail od on(o.orderNo=od.orderNo) inner join product p on ( od.productNo = p.productNo) where  od.subStrtDate >= ? AND od.subEndDate >= ? and od.productNo In(4,5,6) order by orderDate, memId";
		List<OrderList> results = jdbcTemplate.query(sql, new RowMapper<OrderList>() {

			@Override
			public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
				OrderList orderList = new OrderList(
						rs.getString("memId"),
						rs.getTimestamp("orderDate").toLocalDateTime(), 
						rs.getInt("productNo"),
						rs.getString("productName"),
						rs.getInt("productPrice"));
				orderList.setMemId(rs.getString("memId"));					
				return orderList;
			}
			
		}, subDate, todayString);
		return results;
	}
	
	public List<OrderList> selectSubCountDateKeyword(String subDate, String keyword){
		String sql = "SELECT o.memId, o.orderDate, od.productNo, p.productName, p.productPrice " + 
	            " from orderr o inner join order_detail od on(o.orderNo=od.orderNo) inner join product p on ( od.productNo = p.productNo) where  od.subStrtDate >= ? AND od.subEndDate >= ? and p.productName like ? and od.productNo In(4,5,6) order by orderDate, memId";
		List<OrderList> results = jdbcTemplate.query(sql, new RowMapper<OrderList>() {
		    @Override
		    public OrderList mapRow(ResultSet rs, int rowNum) throws SQLException {
		        OrderList orderList = new OrderList(
		                rs.getString("memId"),
		                rs.getTimestamp("orderDate").toLocalDateTime(),
		                rs.getInt("productNo"),
		                rs.getString("productName"),
		                rs.getInt("productPrice"));
		        orderList.setMemId(rs.getString("memId"));
		        return orderList;
		    }
		}, subDate, todayString, "%" + keyword + "%");
		return results;
	}

}
