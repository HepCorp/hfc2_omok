package com.hfc.omok.member;

import java.util.Date;

public class MemberVO {

	int member_no;
	String user_name;
	String user_email;
	String user_pwd;
	int money;
	String ip;
	Date input_dt;
	Date last_dt;

	int match;
	int win;
	int lose;
	int draw;
	int winner_rate;

	public int getMatch() {
		return match;
	}

	public void setMatch(int match) {
		this.match = match;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getWinner_rate() {
		return winner_rate;
	}

	public void setWinner_rate(int winner_rate) {
		this.winner_rate = winner_rate;
	}

	public MemberVO(int member_no, String user_name, String user_email, String user_pwd, int money, String ip,
			Date input_dt, Date last_dt, int match, int win, int lose, int draw, int winner_rate) {
		super();
		this.member_no = member_no;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_pwd = user_pwd;
		this.money = money;
		this.ip = ip;
		this.input_dt = input_dt;
		this.last_dt = last_dt;
		this.match = match;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
		this.winner_rate = winner_rate;
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getInput_dt() {
		return input_dt;
	}

	public void setInput_dt(Date input_dt) {
		this.input_dt = input_dt;
	}

	public Date getLast_dt() {
		return last_dt;
	}

	public void setLast_dt(Date last_dt) {
		this.last_dt = last_dt;
	}

	@Override
	public String toString() {
		return "MemberVO [member_no=" + member_no + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_pwd=" + user_pwd + ", money=" + money + ", ip=" + ip + ", input_dt=" + input_dt + ", last_dt="
				+ last_dt + "]";
	}

}
