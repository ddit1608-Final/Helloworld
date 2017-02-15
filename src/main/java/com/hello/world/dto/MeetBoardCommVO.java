package com.hello.world.dto;

import java.sql.Timestamp;


public class MeetBoardCommVO {

	private String meet_board_ans_code;
	private String meet_board_posting_no;
	private String meet_board_comm_cont;
	private String meet_board_comm_wri;
	private Timestamp meet_board_comm_wridate;
	private String mem_nick;
	private String mem_mail;
	public String getMeet_board_ans_code() {
		return meet_board_ans_code;
	}
	public void setMeet_board_ans_code(String meet_board_ans_code) {
		this.meet_board_ans_code = meet_board_ans_code;
	}
	public String getMeet_board_posting_no() {
		return meet_board_posting_no;
	}
	public void setMeet_board_posting_no(String meet_board_posting_no) {
		this.meet_board_posting_no = meet_board_posting_no;
	}
	public String getMeet_board_comm_cont() {
		return meet_board_comm_cont;
	}
	public void setMeet_board_comm_cont(String meet_board_comm_cont) {
		this.meet_board_comm_cont = meet_board_comm_cont;
	}
	public String getMeet_board_comm_wri() {
		return meet_board_comm_wri;
	}
	public void setMeet_board_comm_wri(String meet_board_comm_wri) {
		this.meet_board_comm_wri = meet_board_comm_wri;
	}
	public Timestamp getMeet_board_comm_wridate() {
		return meet_board_comm_wridate;
	}
	public void setMeet_board_comm_wridate(Timestamp meet_board_comm_wridate) {
		this.meet_board_comm_wridate = meet_board_comm_wridate;
	}
	public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	@Override
	public String toString() {
		return "MeetBoardCommVO [meet_board_ans_code=" + meet_board_ans_code
				+ ", meet_board_posting_no=" + meet_board_posting_no
				+ ", meet_board_comm_cont=" + meet_board_comm_cont
				+ ", meet_board_comm_wri=" + meet_board_comm_wri
				+ ", meet_board_comm_wridate=" + meet_board_comm_wridate
				+ ", mem_nick=" + mem_nick + ", mem_mail=" + mem_mail + "]";
	}
	
	
}
