package com.hfc.omok.member.service;

import com.hfc.omok.member.MemberVO;

public interface MemberService {

	/**
	 * 로그인 정보 가져오
	 * @param String - 회원이메일
	 * @return MemberVO
	 * @exception Exception
	 */
	public MemberVO loginSelect(String user_email);
	
	/**
	 * 로그인시 로그 저장
	 * @param VO - 회원정보가 담긴 MemberVO
	 * @return void
	 * @exception Exception
	 */
	public void logInsert(MemberVO vo);

}
