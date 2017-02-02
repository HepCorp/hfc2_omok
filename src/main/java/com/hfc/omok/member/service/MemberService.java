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

	/**
	 * 로그인시 오목회원 없는 사람 추
	 * @param int - 회원번가 담긴 member_no
	 * @return void
	 * @exception Exception
	 */
	public void omokInsert(int member_no);
}
