package com.hfc.omok.game.service;

import java.util.HashMap;
import java.util.List;

import com.hfc.omok.game.GameVO;

public interface GameService {
	
	/**
	 * 현재게임정보
	 * @param int - 회원번호
	 * @return GameVO - 게임 정보
	 * @exception Exception
	 */
	public GameVO gameSelect(int member_no);
	
	/**
	 * 셀전체 목록
	 * @param void
	 * @return List<HashMap<String, Object>> - 셀 정보(HashMap) 목
	 * @exception Exception
	 */
	public List<HashMap<String, Object>> cellAllSelect();
	
	/**
	 * 문제불러오기
	 * @param cell_no : 셀번호
	 * @return HashMap
	 * @author rachel
	 * @exception Exception
	 */
	public HashMap<String, Object> qnaSelect(int cell_no);
}
