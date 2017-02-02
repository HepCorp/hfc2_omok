package com.hfc.omok.game;

import java.util.Date;

public class GameVO {

	private int game_no;
	private int b_member_no;
	private int w_member_no;
	private int victory;
	private Date input_dt;

	public GameVO(int game_no, int b_member_no, int w_member_no, int victory, Date input_dt) {
		super();
		this.game_no = game_no;
		this.b_member_no = b_member_no;
		this.w_member_no = w_member_no;
		this.victory = victory;
		this.input_dt = input_dt;
	}

	public GameVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGame_no() {
		return game_no;
	}

	public void setGame_no(int game_no) {
		this.game_no = game_no;
	}

	public int getB_member_no() {
		return b_member_no;
	}

	public void setB_member_no(int b_member_no) {
		this.b_member_no = b_member_no;
	}

	public int getW_member_no() {
		return w_member_no;
	}

	public void setW_member_no(int w_member_no) {
		this.w_member_no = w_member_no;
	}

	public int getVictory() {
		return victory;
	}

	public void setVictory(int victory) {
		this.victory = victory;
	}

	public Date getInput_dt() {
		return input_dt;
	}

	public void setInput_dt(Date input_dt) {
		this.input_dt = input_dt;
	}

	@Override
	public String toString() {
		return "GameVO [game_no=" + game_no + ", b_member_no=" + b_member_no + ", w_member_no=" + w_member_no
				+ ", victory=" + victory + ", input_dt=" + input_dt + "]";
	}

}
