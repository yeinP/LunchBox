package com.study.springboot.myPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.log.spring.Member;
import com.study.springboot.log.spring.MemberDao;
import com.study.springboot.log.spring.MemberSession;

@Service
public class MyPageSessionService {

	
	@Autowired
	private MemberDao memberDao;
	
	public MemberSession getSession(String memId) {
		Member member = memberDao.selectByMemId(memId);
	
		return new MemberSession(member.getMemId(), member.getMemName()
				, member.getMemEmail(), member.getMemPhone()
				, member.getMemAddress(), member.getMemTypeNo());
	}
}
