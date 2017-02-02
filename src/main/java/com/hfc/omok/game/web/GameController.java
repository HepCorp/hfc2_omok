package com.hfc.omok.game.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfc.omok.game.GameVO;
import com.hfc.omok.game.HistoryVO;
import com.hfc.omok.game.service.GameService;
import com.hfc.omok.member.MemberVO;

@Controller
@RequestMapping("/game/*")
public class GameController {

	@Autowired
	GameService service;
	
	GameVO game;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	private String main(){
		return "redirect:/game/index.do";
	}
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	private String index(
			  HttpSession session
			, ModelMap model){
		int member_no = getMember_no(session);
		//하던 게임이 있으면 게임을 불러오고
		game = service.gameSelect(member_no);
		
		//하던 게임이 없으면 시작 화면을 불러온다
//		game = null;
//		if (game == null){
//			game = new GameVO();			
//		}
		
		List<HashMap<String, Object>> cell = service.cellAllSelect();
		model.addAttribute("game", game);
		model.addAttribute("cell", cell);
		
		return "/game/index";		
	}
	
	private int getMember_no(HttpSession session){
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO2");
		return memberVO.getMember_no();
	}

	@RequestMapping(value="/question.do", method=RequestMethod.POST)
	private @ResponseBody HashMap<String, Object> callQuestion(
			  @RequestParam(value="no", required=true) int cell_no
			, @RequestParam(value="col", required=true) String color
			, HttpSession session
			, HttpServletRequest request){
		
		HashMap<String, Object> qnaData = service.qnaSelect(cell_no);
		
		return qnaData;
		//HistoryVO history = new HistoryVO(0, game.getGame_no(), game.getB_member_no(), game.getW_member_no(), cell_no, corrent_yn, new Date());
	}
}
