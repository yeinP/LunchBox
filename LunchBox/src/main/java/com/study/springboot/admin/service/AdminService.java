package com.study.springboot.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.admin.spring.MemberList;
import com.study.springboot.log.spring.Member;
import com.study.springboot.log.spring.MemberDao;
@Service
public class AdminService {
	@Autowired
	private MemberDao memberDao;
	
	public MemberList getMemberList(int pageNum) {
		int total = memberDao.memberCount();
		int size = 30;
		List<Member> content = memberDao.listMember((pageNum -1)*size , size);
		return new MemberList(total, pageNum, size, content);
	}
}
