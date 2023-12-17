package com.study.springboot.shop.cart.dtodao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.shop.product.Product;

@Repository
public class CartDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	//회원에게 장바구니 번호 부여
	public void insert(Cart cart) {
		String sql = "insert into cart(cartNo, memId) values (0,?) ";
		jdbcTemplate.update(sql,cart.getMemId());
	}
	
	//회원에게 부여된 장바구니 번호 찾아오기
	public Integer selectCartNo(String id) {
		String sql = "select cartNo from cart where memId=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, id);
	}

	
	//장바구니에 등록할 때 같은 상품이 있는지 확인해서 상품이 있으면 장바구니 등록 번호를 가져오기
	public Integer selectCartDetailNo(Integer cartNo, Integer productNo) {
		String sql = "select cartDetailNo from cart_detail where cartNo=? and productNo=?";
		List<Cart> list = jdbcTemplate.query(sql, (rs,n)->{
			Cart cart = new Cart(0, sql, rs.getInt("cartDetailNo"), 0, sql, 0, 0, 0);
			return cart;
		},cartNo, productNo);
		return list.isEmpty()? 0 : list.get(0).getCartDetailNo();
	}
	
	
	
	//장바구니에 등록
	public void insertCartDetail(CartCommand cartCommand) {
		String sql = "insert into cart_detail(cartNo, productNo, cartAmount) values (?, ?, ?)";
		jdbcTemplate.update(sql, cartCommand.getCartNo(), cartCommand.getProductNo(), cartCommand.getProductAmount());
	}
	
	
	//장바구니에 이미 상품이 있을 때 개수 업데이트
	public void update(Integer cartDetailNo, Integer cartAmount) {
		String sql = "update cart_detail set cartAmount=cartAmount+? where cartDetailNo=?";
		jdbcTemplate.update(sql, cartAmount, cartDetailNo);
	}
	
	
	//장바구니 목록 삭제
	public void delete(int cartDetailNo) {
		String sql = "delete from cart_detail where cartDetailNo=?";
		jdbcTemplate.update(sql, cartDetailNo);
	}
	
	public List<Cart> list(int cartNo){
		
		String sql = "select c.cartNo, c.memId, cd.cartDetailNo, cd.productNo, p.productName, p.productPrice, cd.cartAmount, p.productPrice*cd.cartAmount as price"
				+" from cart c left outer join cart_detail cd on (c.cartNo=cd.cartNo) left outer join product p on(cd.productNo = p.productNo)"
				+" where c.cartNo = ?";
		return jdbcTemplate.query(sql, (rs, n) -> {
			Cart showCart = new Cart(rs.getInt("cartNo"), rs.getString("memId"), rs.getInt("cartDetailNo"), rs.getInt("productNo"), rs.getString("productName"), rs.getInt("productPrice"), rs.getInt("cartAmount"), rs.getInt("price"));
			return showCart;
		}, cartNo);
		
	}
	
	
	//체크한 상품만 결제
	public Cart checkedList(int cartNo, Integer productNo){
		
		String sql = "select c.cartNo, c.memId, cd.cartDetailNo, cd.productNo, p.productName, p.productPrice, cd.cartAmount, p.productPrice*cd.cartAmount as price"
				+" from cart c left outer join cart_detail cd on (c.cartNo=cd.cartNo) left outer join product p on(cd.productNo = p.productNo)"
				+" where c.cartNo = ? and cd.productNo=?";
		List<Cart> list = jdbcTemplate.query(sql, (rs, n) -> {
			Cart showCart = new Cart(rs.getInt("cartNo"), rs.getString("memId"), rs.getInt("cartDetailNo"), rs.getInt("productNo"), rs.getString("productName"), rs.getInt("productPrice"), rs.getInt("cartAmount"), rs.getInt("price"));
			return showCart;
		}, cartNo, productNo);
		
		return list.isEmpty()? null : list.get(0);
	}
	
	
	//결제하면 장바구니에서 모두 삭제
	public void deleteAll() {
		String sql = "delete from cart_detail";
		jdbcTemplate.update(sql);
	}
	

}
