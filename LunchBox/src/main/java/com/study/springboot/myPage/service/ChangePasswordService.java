package com.study.springboot.myPage.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.springboot.log.spring.Member;
import com.study.springboot.log.spring.MemberDao;
import com.study.springboot.log.spring.MemberNotFoundException;
import com.study.springboot.log.spring.WrongPasswordConfirmException;
import com.study.springboot.myPage.spring.ChangeCommand;

@Service
public class ChangePasswordService {

	@Autowired
	private MemberDao memberDao;

	@Transactional
	public void changePassword(String memId, String oldPwd, String newPwd, String newPwdComfirm) {
		Member member = memberDao.selectByMemId(memId);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		if (!newPwd.equals(newPwdComfirm)) {
			throw new WrongPasswordConfirmException();
		}

		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
	
	
	public void changeInfo(String memId, ChangeCommand changeCommand) {
		Member member = memberDao.selectByMemId(memId);
		if (member == null) {
			throw new MemberNotFoundException();
		}

		member.changeEmail(changeCommand.getNewEmail());
		member.changePhone(changeCommand.getNewPhone());
		member.changeAddress(changeCommand.getNewAddress());
		
		memberDao.update(member);
	}

}
