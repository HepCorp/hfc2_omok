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

	public String stoneSelect(Integer game_no) {
		return session.selectOne(namespace +"stoneSelect", game_no);
	}

	public List<HistoryVO> historySelect(int game_no) {
		return session.selectList(namespace +"historySelect", game_no);
	}

	public int memberNoSelect(String user_email) {
		Object result = session.selectOne(namespace +"memberNoSelect", user_email);
		if (result == null) {
			return 0;
		}
		return (Integer) result;
	}

	public void gameInsert(GameVO vo) {
		session.insert(namespace +"gameInsert", vo);
	}

	public void matchUpdate(GameVO vo) {
		session.update(namespace +"matchUpdate", vo);
	}
	
}
