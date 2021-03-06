package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("freeboard")
public class FreeBoardVO {

	private String freeboard_posting_no; // 자유게시판 게시글 번호
	private String mem_mail; // 멤버 테이블 아이디 -> 닉네임가져올것
	private String mem_nick; // 가져 왔다 시부랄 닉네임
	private String freeboard_title; // 자유게시판 제목
	private String freeboard_cont; // 자유게시판 내용
	private Timestamp freeboard_wridate; // 자유게시판 작성일자
	private int freeboard_hits; // 자유게시판 조휘수
	private String freeboard_pwd; // 자유게시판 게시글 비밀번호
	private String freeboard_ans_code;
	private String mem_phn;
	
	
	

	public String getMem_phn() {
		return mem_phn;
	}

	public void setMem_phn(String mem_phn) {
		this.mem_phn = mem_phn;
	}

	public String getFreeboard_ans_code() {
		return freeboard_ans_code;
	}

	public void setFreeboard_ans_code(String freeboard_ans_code) {
		this.freeboard_ans_code = freeboard_ans_code;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getFreeboard_posting_no() {
		return freeboard_posting_no;
	}

	public void setFreeboard_posting_no(String freeboard_posting_no) {
		this.freeboard_posting_no = freeboard_posting_no;
	}

	public String getMem_mail() {
		return mem_mail;
	}

	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}

	public String getFreeboard_title() {
		return freeboard_title;
	}

	public void setFreeboard_title(String freeboard_title) {
		this.freeboard_title = freeboard_title;
	}

	public String getFreeboard_cont() {
		return freeboard_cont;
	}

	public void setFreeboard_cont(String freeboard_cont) {
		this.freeboard_cont = freeboard_cont;
	}

	public Timestamp getFreeboard_wridate() {
		return freeboard_wridate;
	}

	public void setFreeboard_wridate(Timestamp freeboard_wridate) {
		this.freeboard_wridate = freeboard_wridate;
	}

	public int getFreeboard_hits() {
		return freeboard_hits;
	}

	public void setFreeboard_hits(int freeboard_hits) {
		this.freeboard_hits = freeboard_hits;
	}

	public String getFreeboard_pwd() {
		return freeboard_pwd;
	}

	public void setFreeboard_pwd(String freeboard_pwd) {
		this.freeboard_pwd = freeboard_pwd;
	}

	@Override
	public String toString() {
		return "FreeBoardVO [freeboard_posting_no=" + freeboard_posting_no
				+ ", mem_mail=" + mem_mail + ", mem_nick=" + mem_nick
				+ ", freeboard_title=" + freeboard_title + ", freeboard_cont="
				+ freeboard_cont + ", freeboard_wridate=" + freeboard_wridate
				+ ", freeboard_hits=" + freeboard_hits + ", freeboard_pwd="
				+ freeboard_pwd + ", freeboard_ans_code=" + freeboard_ans_code
				+ ", mem_phn=" + mem_phn + "]";
	}

	
	

}