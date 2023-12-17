package com.study.springboot.shop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> selectAll(){
		String sql = "select productNo, productName, productPrice from product";
		List<Product> list = jdbcTemplate.query(sql, (rs,n)->{
			Product product = new Product(rs.getInt("productNo"),
										  rs.getString("productName"),
										  rs.getInt("productPrice"));
			return product;
		});
		return list;
	}
	
	public List<Product> selectList() {
		String sql = "select * from product";
		List<Product> list = jdbcTemplate.query(sql, (rs,n)-> {
			Product product = new Product (
			rs.getInt("productNo"),
			rs.getString("productName"),
			rs.getInt("productPrice"));
		return product;
		});
		return list;
	}

}
