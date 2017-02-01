package com.hello.world.dto;

import java.security.Timestamp;

public class MeetBoardVO {

	private String meet_board_posting_no; // 모임게시판 게시글 번호
	private String mem_mail; // 멤버 테이블 아이디->닉네임 가져올것
	private String meet_board_nick; // 가져왔다 씨부럴ㅇ닉네임
	private String meet_board_title; // 모임게시판 제목
	private int meet_hits; // 모임게시판 조회수
	private String meet_board_cont; // 모임게시판 내용
	private Timestamp meet_board_wri_date; //  모임게시판 작성 일자
	private String flow_code;
	public String getMeet_board_posting_no() {
		return meet_board_posting_no;
	}
	public void setMeet_board_posting_no(String meet_board_posting_no) {
		this.meet_board_posting_no = meet_board_posting_no;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMeet_board_nick() {
		return meet_board_nick;
	}
	public void setMeet_board_nick(String meet_board_nick) {
		this.meet_board_nick = meet_board_nick;
	}
	public String getMeet_board_title() {
		return meet_board_title;
	}
	public void setMeet_board_title(String meet_board_title) {
		this.meet_board_title = meet_board_title;
	}
	public int getMeet_hits() {
		return meet_hits;
	}
	public void setMeet_hits(int meet_hits) {
		this.meet_hits = meet_hits;
	}
	public String getMeet_board_cont() {
		return meet_board_cont;
	}
	public void setMeet_board_cont(String meet_board_cont) {
		this.meet_board_cont = meet_board_cont;
	}
	public Timestamp getMeet_board_wri_date() {
		return meet_board_wri_date;
	}
	public void setMeet_board_wri_date(Timestamp meet_board_wri_date) {
		this.meet_board_wri_date = meet_board_wri_date;
	}
	public String getFlow_code() {
		return flow_code;
	}
	public void setFlow_code(String flow_code) {
		this.flow_code = flow_code;
	}
	@Override
	public String toString() {
		return "MeetBoardVO [meet_board_posting_no=" + meet_board_posting_no
				+ ", mem_mail=" + mem_mail + ", meet_board_nick="
				+ meet_board_nick + ", meet_board_title=" + meet_board_title
				+ ", meet_hits=" + meet_hits + ", meet_board_cont="
				+ meet_board_cont + ", meet_board_wri_date="
				+ meet_board_wri_date + ", flow_code=" + flow_code + "]";
	}

}
