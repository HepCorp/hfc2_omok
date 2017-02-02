package com.hfc.omok.game.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hfc.omok.game.GameVO;
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
	public List<HashMap<String, Object>> cellAllSelect() {
		return dao.cellAllSelect();
	}

	@Override
	public HashMap<String, Object> qnaSelect(int cell_no) {
		return dao.qnaSelect(cell_no);
	}

}