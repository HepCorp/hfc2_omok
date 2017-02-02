package com.hfc.omok.member.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hfc.omok.member.MemberVO;
import com.hfc.omok.member.service.MemberService;

@Controller
@RequestMapping("/*")
public class MemberController {

	@Autowired
	LoginValidation loginVal;
	
	@Resource(name="memberService")
	MemberService service;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main(){
		return "redirect:/index.do";
	}
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String index(HttpSession session){
		session.removeAttribute("memberVO2");
		//session.invalidate();
		
		return "/index";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(
			  @ModelAttribute("memberVO") MemberVO memberVO
			, BindingResult result
			, HttpSession session
			, HttpServletRequest request
			, ModelMap model){
		loginVal.validate(memberVO, result);
		if (result.hasErrors()) {
			return "/index";
		}
		memberVO.setIp(request.getRemoteAddr());
		
		service.logInsert(memberVO);
		service.omokInsert(memberVO.getMember_no());
		session.setAttribute("memberVO2", memberVO);
		
		return "redirect:/game/index.do";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("memberVO2");
		//session.invalidate();

		return "redirect:/index.do";
	}

}
