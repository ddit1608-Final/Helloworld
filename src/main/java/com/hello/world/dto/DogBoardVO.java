package com.hello.world.dto;

import java.sql.Timestamp;

public class DogBoardVO {
	
	private String dsboard_posting_no; // 게시글 번호
	private String dsboard_title;	  // 게시글 제목
	private String dsboard_cont;		  // 게시글 내용
	private Timestamp dsboard_wridate; // 게시글 날짜
	private int dsboard_hits;		  // 게시글 조회수
	private String dsboard_pwd;		  // 게시글 비번
	private String mem_mail;			  // 작성자 메일
	private String mem_nick;			  // 작성자 메일
	private String mem_phn;				  // 작성자 연락처
	private String type_key; 			  // 게시글 말머리
	private String type_value;
	public String getDsboard_posting_no() {
		return dsboard_posting_no;
	}
	public void setDsboard_posting_no(String dsboard_posting_no) {
		this.dsboard_posting_no = dsboard_posting_no;
	}
	public String getDsboard_title() {
		return dsboard_title;
	}
	public void setDsboard_title(String dsboard_title) {
		this.dsboard_title = dsboard_title;
	}
	public String getDsboard_cont() {
		return dsboard_cont;
	}
	public void setDsboard_cont(String dsboard_cont) {
		this.dsboard_cont = dsboard_cont;
	}
	public Timestamp getDsboard_wridate() {
		return dsboard_wridate;
	}
	public void setDsboard_wridate(Timestamp dsboard_wridate) {
		this.dsboard_wridate = dsboard_wridate;
	}
	public int getDsboard_hits() {
		return dsboard_hits;
	}
	public void setDsboard_hits(int dsboard_hits) {
		this.dsboard_hits = dsboard_hits;
	}
	public String getDsboard_pwd() {
		return dsboard_pwd;
	}
	public void setDsboard_pwd(String dsboard_pwd) {
		this.dsboard_pwd = dsboard_pwd;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	public String getMem_phn() {
		return mem_phn;
	}
	public void setMem_phn(String mem_phn) {
		this.mem_phn = mem_phn;
	}
	public String getType_key() {
		return type_key;
	}
	public void setType_key(String type_key) {
		this.type_key = type_key;
	}
	public String getType_value() {
		return type_value;
	}
	public void setType_value(String type_value) {
		this.type_value = type_value;
	}
	
	
	
	
	
	
	
}