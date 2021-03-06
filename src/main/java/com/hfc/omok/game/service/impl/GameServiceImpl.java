package com.hfc.omok.game.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hfc.omok.game.GameVO;
import com.hfc.omok.game.HistoryVO;
import com.hfc.omok.game.service.GameDAO;
import com.hfc.omok.game.service.GameService;

@Service("gameService")
public class GameServiceImpl implements GameService {

	@Resource(name="gameDao")
	GameDAO dao;
	
	@Override
	public GameVO gameSelect(int member_no) {
		return dao.gameSelect(member_no);
	}

	@Override
	public List<HashMap<String, Object>> cellAllSelect(int game_no) {
		return dao.cellAllSelect(game_no);
	}

	@Override
	public HashMap<String, Object> qnaSelect(int cell_no) {
		return dao.qnaSelect(cell_no);
	}

	@Override
	public void historyInsert(HistoryVO vo) {
		dao.historyInsert(vo);
	}

	@Override
	public String stoneSelect(Integer game_no) {
		return dao.stoneSelect(game_no);
	}

	@Override
	public List<HistoryVO> historySelect(int game_no) {
		return dao.historySelect(game_no);
	}

	@Override
	public int memberNoSelect(String user_email) {
		return dao.memberNoSelect(user_email);
	}

	@Override
	public void gameInsert(GameVO vo) {
		dao.gameInsert(vo);
	}

	@Override
	public void matchUpdate(GameVO vo) {
		dao.matchUpdate(vo);
	}

}