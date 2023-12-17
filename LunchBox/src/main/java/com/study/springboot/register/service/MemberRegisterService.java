package com.study.springboot.register.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.log.spring.Member;
import com.study.springboot.log.spring.MemberDao;
import com.study.springboot.register.spring.DuplicateMemberException;


import com.study.springboot.register.spring.RegisterRequest;

@Service
public class MemberRegisterService {
	
	@Autowired
	private MemberDao memberDao;


	public String regist(RegisterRequest req) {
		Member memberId = memberDao.selectById(req.getMemId());
		Member memberEmail = memberDao.selectByEmail(req.getMemEmail()); 
		//아이디확인 후 이메일도 확인
		if (memberId != null || memberEmail != null) {
			throw new DuplicateMemberException("dup memId" + req.getMemId());
		} 		 
		Member newMember = new Member(
				req.getMemId(), req.getMemPassword(), req.getMemName(), req.getMemEmail(), req.getMemPhone(), req.getMemAddress(), 
				LocalDateTime.now(), req.getMemTypeNo());
		memberDao.insert(newMember);
		return newMember.getMemId();
	}
}
