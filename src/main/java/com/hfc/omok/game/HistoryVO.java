package com.hfc.omok.game;

import java.util.Date;

public class HistoryVO {

	private int history_no;
	private int game_no;
	private int b_member_no;
	private int w_member_no;
	private int cell_no;
	private boolean corrent_yn;
	private Date input_dt;

	public HistoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoryVO(int history_no, int game_no, int b_member_no, int w_member_no, int cell_no, boolean corrent_yn,
			Date input_dt) {
		super();
		this.history_no = history_no;
		this.game_no = game_no;
		this.b_member_no = b_member_no;
		this.w_member_no = w_member_no;
		this.cell_no = cell_no;
		this.corrent_yn = corrent_yn;
		this.input_dt = input_dt;
	}

	public int getHistory_no() {
		return history_no;
	}

	public void setHistory_no(int history_no) {
		this.history_no = history_no;
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

	public int getCell_no() {
		return cell_no;
	}

	public void setCell_no(int cell_no) {
		this.cell_no = cell_no;
	}

	public boolean isCorrent_yn() {
		return corrent_yn;
	}

	public void setCorrent_yn(boolean corrent_yn) {
		this.corrent_yn = corrent_yn;
	}

	public Date getInput_dt() {
		return input_dt;
	}

	public void setInput_dt(Date input_dt) {
		this.input_dt = input_dt;
	}

	@Override
	public String toString() {
		return "HistoryVO [history_no=" + history_no + ", game_no=" + game_no + ", b_member_no=" + b_member_no
				+ ", w_member_no=" + w_member_no + ", cell_no=" + cell_no + ", corrent_yn=" + corrent_yn + ", input_dt="
				+ input_dt + "]";
	}

}
