package com.study.springboot.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.admin.model.OrderList;
import com.study.springboot.admin.spring.SearchDao;

@Service
public class searchService {
	@Autowired
	private SearchDao searchDao;
	public int countDateCom(String start, String end) {
		return searchDao.selectCountDate(start, end);
	}
	
	public List<OrderList> searchDate(String start, String end) {
		return searchDao.listByOrderDate(start, end);
	}
	public List<OrderList> searchDateKeyword(String start, String end, String keyword) {
		return searchDao.selectCountDateKeyword(start, end, keyword);
	}
	
	public List<OrderList> searchSubDate(String date) {
		return searchDao.listBySubDate(date);
	}
	public List<OrderList> searchSubDateKeyword(String date, String keyword) {
		return searchDao.selectSubCountDateKeyword(date, keyword);
	}
}
