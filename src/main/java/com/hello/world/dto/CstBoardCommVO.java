package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("cstcomm")
public class CstBoardCommVO {
	private String cstboard_ans_code;
	private String cstboard_ans_cont;
	private String cstboard_ans_wri;
	private Timestamp cstboard_ans_wridate;
	private String cstboard_counsel_posting_no;
	private String mem_mail;
	private String mem_nick;
	private String mem_phn;
	
	
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
	public String getCstboard_ans_code() {
		return cstboard_ans_code;
	}
	public void setCstboard_ans_code(String cstboard_ans_code) {
		this.cstboard_ans_code = cstboard_ans_code;
	}
	public String getCstboard_ans_cont() {
		return cstboard_ans_cont;
	}
	public void setCstboard_ans_cont(String cstboard_ans_cont) {
		this.cstboard_ans_cont = cstboard_ans_cont;
	}
	public String getCstboard_ans_wri() {
		return cstboard_ans_wri;
	}
	public void setCstboard_ans_wri(String cstboard_ans_wri) {
		this.cstboard_ans_wri = cstboard_ans_wri;
	}
	public Timestamp getCstboard_ans_wridate() {
		return cstboard_ans_wridate;
	}
	public void setCstboard_ans_wridate(Timestamp cstboard_ans_wridate) {
		this.cstboard_ans_wridate = cstboard_ans_wridate;
	}
	public String getCstboard_counsel_posting_no() {
		return cstboard_counsel_posting_no;
	}
	public void setCstboard_counsel_posting_no(String cstboard_counsel_posting_no) {
		this.cstboard_counsel_posting_no = cstboard_counsel_posting_no;
	}

	
	
}
