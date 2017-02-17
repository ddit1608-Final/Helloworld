package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("meetboard")
public class MeetBoardVO {

	private String meet_board_posting_no; // 모임게시판 게시글 번호
	private String mem_mail; // 멤버 테이블 아이디->닉네임 가져올것
	private String mem_nick; // 가져왔다 씨부럴ㅇ닉네임
	private String meet_board_title; // 모임게시판 제목
	private int meet_hits; // 모임게시판 조회수
	private String meet_board_cont; // 모임게시판 내용
	private Timestamp meet_board_wridate; // 모임게시판 작성 일자
	private String flow_code; // 말머리
	private String meet_board_pwd;
	private String key;
	private String mem_phn;

	@Override
	public String toString() {
		return "MeetBoardVO [meet_board_posting_no=" + meet_board_posting_no
				+ ", mem_mail=" + mem_mail + ", mem_nick=" + mem_nick
				+ ", meet_board_title=" + meet_board_title + ", meet_hits="
				+ meet_hits + ", meet_board_cont=" + meet_board_cont
				+ ", meet_board_wridate=" + meet_board_wridate
				+ ", flow_code=" + flow_code + ", meet_board_pwd="
				+ meet_board_pwd + ", key=" + key + ", mem_phn=" + mem_phn
				+ "]";
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public String getMem_phn() {
		return mem_phn;
	}

	public void setMem_phn(String mem_phn) {
		this.mem_phn = mem_phn;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMeet_board_pwd() {
		return meet_board_pwd;
	}

	public void setMeet_board_pwd(String meet_board_pwd) {
		this.meet_board_pwd = meet_board_pwd;
	}

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
		return meet_board_wridate;
	}

	public void setMeet_board_wri_date(Timestamp meet_board_wri_date) {
		this.meet_board_wridate = meet_board_wri_date;
	}

	public String getFlow_code() {
		return flow_code;
	}

	public void setFlow_code(String flow_code) {
		this.flow_code = flow_code;
	}

}
