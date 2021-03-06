package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("ifshrboard")
public class IfShrBoardVO {
	
	private String ifshrboard_posting_no; // 게시글 번호
	private String ifshrboard_title;	  // 게시글 제목
	private String ifshrboard_cont;		  // 게시글 내용
	private Timestamp ifshrboard_wridate; // 게시글 날짜
	private int ifshrboard_hits;		  // 게시글 조회수
	private String ifshrboard_pwd;		  // 게시글 비번
	private String mem_mail;			  // 작성자 메일
	private String mem_nick;			  // 작성자 메일
	private String mem_phn;				  // 작성자 연락처
	private String type_key; 			  // 게시글 말머리
	private String type_value;
	private String crr_key;				  // 정보공유 게시글 난이도 
	private String crr_value;
	
	
	public String getCrr_key() {
		return crr_key;
	}
	public void setCrr_key(String crr_key) {
		this.crr_key = crr_key;
	}
	public String getCrr_value() {
		return crr_value;
	}
	public void setCrr_value(String crr_value) {
		this.crr_value = crr_value;
	}
	public String getType_value() {
		return type_value;
	}
	public void setType_value(String type_value) {
		this.type_value = type_value;
	}
	public String getType_key() {
		return type_key;
	}
	public void setType_key(String type_key) {
		this.type_key = type_key;
	}
	public String getMem_phn() {
		return mem_phn;
	}
	public void setMem_phn(String mem_phn) {
		this.mem_phn = mem_phn;
	}
	public String getIfshrboard_posting_no() {
		return ifshrboard_posting_no;
	}
	public void setIfshrboard_posting_no(String ifshrboard_posting_no) {
		this.ifshrboard_posting_no = ifshrboard_posting_no;
	}
	public String getIfshrboard_title() {
		return ifshrboard_title;
	}
	public void setIfshrboard_title(String ifshrboard_title) {
		this.ifshrboard_title = ifshrboard_title;
	}
	public String getIfshrboard_cont() {
		return ifshrboard_cont;
	}
	public void setIfshrboard_cont(String ifshrboard_cont) {
		this.ifshrboard_cont = ifshrboard_cont;
	}
	public Timestamp getIfshrboard_wridate() {
		return ifshrboard_wridate;
	}
	public void setIfshrboard_wridate(Timestamp ifshrboard_wridate) {
		this.ifshrboard_wridate = ifshrboard_wridate;
	}
	public int getIfshrboard_hits() {
		return ifshrboard_hits;
	}
	public void setIfshrboard_hits(int ifshrboard_hits) {
		this.ifshrboard_hits = ifshrboard_hits;
	}
	public String getIfshrboard_pwd() {
		return ifshrboard_pwd;
	}
	public void setIfshrboard_pwd(String ifshrboard_pwd) {
		this.ifshrboard_pwd = ifshrboard_pwd;
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
	
	
	
}