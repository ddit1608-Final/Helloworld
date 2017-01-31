package com.hello.world.dto;

import java.sql.Timestamp;

public class QnaBoardVO {
	
	private String qnaboard_posting_no;
	private String qnaboard_title;
	private String qnaboard_cont;
	private Timestamp qnaboard_wridate;
	private int qnaboard_hits;
	private String qnaboard_pwd;
	private String mem_mail;
	
	
	public String getQnaboard_posting_no() {
		return qnaboard_posting_no;
	}
	public void setQnaboard_posting_no(String qnaboard_posting_no) {
		this.qnaboard_posting_no = qnaboard_posting_no;
	}
	public String getQnaboard_title() {
		return qnaboard_title;
	}
	public void setQnaboard_title(String qnaboard_title) {
		this.qnaboard_title = qnaboard_title;
	}
	public String getQnaboard_cont() {
		return qnaboard_cont;
	}
	public void setQnaboard_cont(String qnaboard_cont) {
		this.qnaboard_cont = qnaboard_cont;
	}
	public Timestamp getQnaboard_wridate() {
		return qnaboard_wridate;
	}
	public void setQnaboard_wridate(Timestamp qnaboard_wridate) {
		this.qnaboard_wridate = qnaboard_wridate;
	}
	public int getQnaboard_hits() {
		return qnaboard_hits;
	}
	public void setQnaboard_hits(int qnaboard_hits) {
		this.qnaboard_hits = qnaboard_hits;
	}
	public String getQnaboard_pwd() {
		return qnaboard_pwd;
	}
	public void setQnaboard_pwd(String qnaboard_pwd) {
		this.qnaboard_pwd = qnaboard_pwd;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	
	
	@Override
	public String toString() {
		return "QnaBoardVO [qnaboard_posting_no=" + qnaboard_posting_no
				+ ", qnaboard_title=" + qnaboard_title + ", qnaboard_cont="
				+ qnaboard_cont + ", qnaboard_wridate=" + qnaboard_wridate
				+ ", qnaboard_hits=" + qnaboard_hits + ", qnaboard_pwd="
				+ qnaboard_pwd + ", mem_mail=" + mem_mail + "]";
	}
	
	
	
	
}