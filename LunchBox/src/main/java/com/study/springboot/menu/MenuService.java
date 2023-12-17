package com.study.springboot.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.shop.product.Product;
import com.study.springboot.shop.product.ProductDao;



@Service
public class MenuService {
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProductList() {
		return productDao.selectList();
		
	}

}
