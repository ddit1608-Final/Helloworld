package com.hello.world.dto;

import java.sql.Timestamp;
import java.util.Date;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("dogcomm")
public class DogBoardCommVO {
	
	private String dsboard_ans_code;			// 답변코드 seq 
	private String dsboard_posting_no;		// 해당게시글 번호(seq)
	private String dsboard_comm_cont;			// 답변 내용
	private String dsboard_comm_wri;			// 답변 작성자 nick 가져올것 == mem_mail
	private Timestamp dsboard_comm_wridate;		// 답변 작성날짜	
	private String mem_nick;
	private String mem_mail;
	public String getDsboard_ans_code() {
		return dsboard_ans_code;
	}
	public void setDsboard_ans_code(String dsboard_ans_code) {
		this.dsboard_ans_code = dsboard_ans_code;
	}
	public String getDsboard_posting_no() {
		return dsboard_posting_no;
	}
	public void setDsboard_posting_no(String dsboard_posting_no) {
		this.dsboard_posting_no = dsboard_posting_no;
	}
	public String getDsboard_comm_cont() {
		return dsboard_comm_cont;
	}
	public void setDsboard_comm_cont(String dsboard_comm_cont) {
		this.dsboard_comm_cont = dsboard_comm_cont;
	}
	public String getDsboard_comm_wri() {
		return dsboard_comm_wri;
	}
	public void setDsboard_comm_wri(String dsboard_comm_wri) {
		this.dsboard_comm_wri = dsboard_comm_wri;
	}
	public Timestamp getDsboard_comm_wridate() {
		return dsboard_comm_wridate;
	}
	public void setDsboard_comm_wridate(Timestamp dsboard_comm_wridate) {
		this.dsboard_comm_wridate = dsboard_comm_wridate;
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
	
	
	
	
	
	
}