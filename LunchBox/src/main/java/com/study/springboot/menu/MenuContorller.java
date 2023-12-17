package com.study.springboot.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.shop.product.Product;
import com.study.springboot.shop.product.ProductDao;







@Controller
@RequestMapping("/menu")
public class MenuContorller {
	
	@Autowired
	public ProductListService productListService;
	@Autowired
	private ProductDao productDao;
	
	
	@GetMapping
	public String listProduct(Model model) {
		List<Product> product = productListService.getProductList();
		model.addAttribute("product", product);
		return "menu/menu";
	}
}
