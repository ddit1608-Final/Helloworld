package com.hello.world.dto;

import java.sql.Timestamp;
import java.util.Date;

public class IsBoardCommVO {
	
	private String ifshrboard_ans_code;			// 답변코드 seq 
	private String ifshrboard_posting_no;		// 해당게시글 번호(seq)
	private String ifshrboard_comm_cont;			// 답변 내용
	private String ifshrboard_comm_wri;			// 답변 작성자 nick 가져올것 == mem_mail
	private Timestamp ifshrboard_comm_wridate;		// 답변 작성날짜	
	private String mem_nick;
	private String mem_mail;
	public String getIfshrboard_ans_code() {
		return ifshrboard_ans_code;
	}
	public void setIfshrboard_ans_code(String ifshrboard_ans_code) {
		this.ifshrboard_ans_code = ifshrboard_ans_code;
	}
	public String getIfshrboard_posting_no() {
		return ifshrboard_posting_no;
	}
	public void setIfshrboard_posting_no(String ifshrboard_posting_no) {
		this.ifshrboard_posting_no = ifshrboard_posting_no;
	}
	public String getIfshrboard_comm_cont() {
		return ifshrboard_comm_cont;
	}
	public void setIfshrboard_comm_cont(String ifshrboard_comm_cont) {
		this.ifshrboard_comm_cont = ifshrboard_comm_cont;
	}
	public String getIfshrboard_comm_wri() {
		return ifshrboard_comm_wri;
	}
	public void setIfshrboard_comm_wri(String ifshrboard_comm_wri) {
		this.ifshrboard_comm_wri = ifshrboard_comm_wri;
	}
	public Timestamp getIfshrboard_comm_wridate() {
		return ifshrboard_comm_wridate;
	}
	public void setIfshrboard_comm_wridate(Timestamp ifshrboard_comm_wridate) {
		this.ifshrboard_comm_wridate = ifshrboard_comm_wridate;
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
		return "IsBoardCommVO [ifshrboard_ans_code=" + ifshrboard_ans_code
				+ ", ifshrboard_posting_no=" + ifshrboard_posting_no
				+ ", ifshrboard_comm_cont=" + ifshrboard_comm_cont
				+ ", ifshrboard_comm_wri=" + ifshrboard_comm_wri
				+ ", ifshrboard_comm_wridate=" + ifshrboard_comm_wridate
				+ ", mem_nick=" + mem_nick + ", mem_mail=" + mem_mail + "]";
	}
	
	
	
	
}