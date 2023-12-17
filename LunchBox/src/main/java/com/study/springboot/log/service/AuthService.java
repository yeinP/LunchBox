package com.study.springboot.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.log.spring.AuthInfo;
import com.study.springboot.log.spring.Member;
import com.study.springboot.log.spring.MemberDao;
import com.study.springboot.log.spring.WrongIdPasswordException;

@Service
public class AuthService {

	@Autowired
	private MemberDao memberDao;

	public AuthInfo authenticate(String memId, String memPassword) {
		Member member = memberDao.selectByMemId(memId);
		if (member == null) {
			throw new WrongIdPasswordException();
		}
		if (!member.matchPassword(memPassword)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(member.getMemId(),
				member.getMemEmail(),
				member.getMemName());
	}

}
