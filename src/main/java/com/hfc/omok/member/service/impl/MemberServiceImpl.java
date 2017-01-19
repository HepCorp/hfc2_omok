package com.hfc.omok.member.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hfc.omok.member.MemberVO;
import com.hfc.omok.member.service.MemberDao;
import com.hfc.omok.member.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name="memberDAO")
	MemberDao dao;

	@Override
	public MemberVO loginSelect(String user_email) {
		return dao.loginSelect(user_email);
	}

	@Override
	public void logInsert(MemberVO vo) {
		dao.logInsert(vo);
	}

}
