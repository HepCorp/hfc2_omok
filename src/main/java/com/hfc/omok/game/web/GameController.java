package com.hfc.omok.game.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	private String stone = "B";
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	private String main(){
		return "redirect:/game/index.do";
	}
	
	private void init(HttpSession session){
		int member_no = getMember_no(session);
		
		//하던 게임이 있으면 게임을 불러오고
		game = service.gameSelect(member_no);
		if (game != null) {
			//흑돌인지 흰돌인지 가지고 옴
			stone = service.stoneSelect(game.getGame_no());
			if (stone == null) stone = "B";
			game.setStone(stone);
		} else {
			game = new GameVO();
		}
	}
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	private String index(
			  HttpSession session
			, ModelMap model){
		init(session);
		
		List<HashMap<String, Object>> cell = service.cellAllSelect(game.getGame_no());
		List<HistoryVO> history = service.historySelect(game.getGame_no());
		model.addAttribute("game", game);
		model.addAttribute("cell", cell);
		model.addAttribute("history", history);
		
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
	}
	
	@RequestMapping(value="/downloadFile.do")
	public void downloadFile(
			  @RequestParam(value="file", required=true) String attach_file
			, HttpServletResponse response
			, HttpServletRequest request) throws Exception{
	    String dataDirectory = request.getSession().getServletContext().getRealPath("/resources/attach/");
	    Path file = Paths.get(dataDirectory, attach_file);
	    
	    if (Files.exists(file)) 
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+attach_file);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}

	@RequestMapping(value="/save.do", method=RequestMethod.POST)
	private String save(
			  @ModelAttribute("historyVO") HistoryVO inVO
		    , HttpSession session, ModelMap mode){
		HashMap<String, Object> qnaData = service.qnaSelect(inVO.getCell_no());
		inVO.setStone(stone.substring(0,1).toUpperCase());
		String correct = (String) qnaData.get("ANSWER");
		if (correct.equals(inVO.getAnswer())) {
			inVO.setCorrect_yn(true);
		} else {
			inVO.setCorrect_yn(false);
		}
		
		service.historyInsert(inVO);
		
		return "redirect:/game/index.do";
	}
	
	@RequestMapping(value="/start.do", method=RequestMethod.POST)
	private String start(@ModelAttribute("gameVO") GameVO inVO
			, Errors err){
		int w_member_no = service.memberNoSelect(inVO.getW_user_email());
		if (w_member_no == 0){
			err.rejectValue("w_user_email", "field.error.account");
			return "/game/index";
		}
		inVO.setW_member_no(w_member_no);
		
		service.gameInsert(inVO);
		service.matchUpdate(inVO);
		
		return "redirect:/game/index.do";
	}

}
