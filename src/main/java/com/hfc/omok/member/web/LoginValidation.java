package com.hfc.omok.member.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hfc.omok.comm.ParamValidatChk;
import com.hfc.omok.member.MemberVO;
import com.hfc.omok.member.service.MemberService;

@Component
public class LoginValidation extends ParamValidatChk implements Validator {

	@Resource(name="memberService")
	MemberService service;
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors err) {
		MemberVO inVO = (MemberVO) target;

		String input_email;
		String input_pwd;
		
		if (isNull(inVO)){
			input_email = "";
			input_pwd = "";
		} else {
			input_email = getParam(inVO.getUser_email());
			input_pwd = getParam(inVO.getUser_pwd());
		}
		if (isEmpty(input_email)){
			err.rejectValue("user_email", "field.required.email");
			return;
		}
		if (!pattern("email", input_email)){
			err.rejectValue("user_email", "field.error.pattern.email");
			return;
		}
		if (isEmpty(input_pwd)){
			err.rejectValue("user_pwd", "field.required.password");
			return;
		}
		MemberVO outVO = service.loginSelect(input_email);
		
		if (isNull(outVO)){
			err.rejectValue("user_email", "field.error.account");
			return;
		}
		int member_no = outVO.getMember_no();
		String user_pwd = outVO.getUser_pwd();
		
		if (isNull(member_no) || member_no == 0 || isEmpty(user_pwd)){
			err.rejectValue("user_email", "field.error.account");
			return;
		}
		if (!input_pwd.equals(user_pwd)){
			err.rejectValue("user_pwd", "field.error.password"); 
			return;
		}
		inVO.setMember_no(outVO.getMember_no());
		inVO.setUser_name(outVO.getUser_name());
 		inVO.setIp(outVO.getIp());
		inVO.setInput_dt(outVO.getInput_dt());
		inVO.setLast_dt(outVO.getLast_dt());
		inVO.setMatch(outVO.getMatch());
		inVO.setWin(outVO.getWin());
		inVO.setLose(outVO.getLose());
		inVO.setDraw(outVO.getDraw());
		inVO.setWinner_rate(outVO.getWinner_rate());
	}
}
