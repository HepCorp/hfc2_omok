package com.hfc.omok.game.service;

import java.util.HashMap;
import java.util.List;

import com.hfc.omok.game.GameVO;
import com.hfc.omok.game.HistoryVO;

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
	public List<HashMap<String, Object>> cellAllSelect(int game_no);
	
	/**
	 * 문제불러오기
	 * @param cell_no : 셀번호
	 * @return HashMap
	 * @author rachel
	 * @exception Exception
	 */
	public HashMap<String, Object> qnaSelect(int cell_no);
	
	/**
	 * 히스토리 저장
	 * @param HistoryVO
	 * @return void
	 * @author rachel
	 * @exception Exception
	 */
	public void historyInsert(HistoryVO vo);
	
	/**
	 * 스톤 순서 가져오기
	 * @param Integer
	 * @return String
	 * @author rachel
	 * @exception Exception
	 */
	public String stoneSelect(Integer game_no);
	
	/**
	 * 진행 히스토리 목록
	 * @param Integer game_no
	 * @return HistoryVO
	 * @author rachel
	 * @exception Exception
	 */
	public List<HistoryVO> historySelect(int game_no);
	
	/**
	 * 회원번호 가져오기
	 * @param String user_email
	 * @return Integer member_no
	 * @author rachel
	 * @exception Exception
	 */
	public int memberNoSelect(String user_email);
	
	/**
	 * 게임 시작 삽입
	 * @param GameVO
	 * @return void
	 * @author rachel
	 * @exception Exception
	 * @date 2017-02-03
	 */
	public void gameInsert(GameVO vo);
	
	/**
	 * 게임 대전 수 업데이트
	 * @param GameVO
	 * @return void
	 * @author rachel
	 * @exception Exception
	 * @date 2017-02-03
	 */
	public void matchUpdate(GameVO vo);
}
