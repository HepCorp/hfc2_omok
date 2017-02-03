package com.hfc.omok.comm;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hfc.omok.member.MemberVO;


public class SessionInterceptor extends HandlerInterceptorAdapter {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//임시로그인
		//request.getSession().setAttribute("memberVO2", new MemberVO(2, "윤수연", "rai007@naver", "123456", 10, "0.0.0.0", new Date(), new Date(), 0, 0, 0, 0, 0));
		StringBuffer mainPage = request.getRequestURL();
		MemberVO member = (MemberVO) request.getSession().getAttribute("memberVO2");
		Boolean game = mainPage.toString().contains("/game/");
		
		if (game) {
			if (member == null){
				response.sendRedirect(request.getContextPath() +"/index.do");
				return false;
			} 
		}
		return true;
	}
}