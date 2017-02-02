package com.hfc.omok.game.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hfc.omok.game.GameVO;
import com.hfc.omok.game.HistoryVO;

@Repository("gameDao")
public class GameDAO {

	private String namespace = "gameMapper.";
	
	@Autowired
	SqlSessionTemplate session;
	
	public GameVO gameSelect(int member_no){
		return session.selectOne(namespace + "gameSelect", member_no);
	}
	
	public List<HashMap<String, Object>> cellAllSelect(int game_no){
		return session.selectList(namespace +"cellAllSelect", game_no);
	}

	public HashMap<String, Object> qnaSelect(int cell_no) {
		return session.selectOne(namespace +"qnaSelect", cell_no);
	}

	public void historyInsert(HistoryVO vo) {
		session.insert(namespace +"historyInsert", vo);
	}
	
}
