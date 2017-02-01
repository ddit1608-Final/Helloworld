package com.hello.world.dto;

import java.sql.Timestamp;

public class QnaBoardCommVO {
	
	private String qnaboard_ans_code;
	private String qnaboard_comm_cont;
	private String qnaboard_comm_wri;
	private Timestamp qnaboard_comm_wridate;
	private String qnaboard_posting_no;
	
	
	public String getQnaboard_ans_code() {
		return qnaboard_ans_code;
	}
	public void setQnaboard_ans_code(String qnaboard_ans_code) {
		this.qnaboard_ans_code = qnaboard_ans_code;
	}
	public String getQnaboard_comm_cont() {
		return qnaboard_comm_cont;
	}
	public void setQnaboard_comm_cont(String qnaboard_comm_cont) {
		this.qnaboard_comm_cont = qnaboard_comm_cont;
	}
	public String getQnaboard_comm_wri() {
		return qnaboard_comm_wri;
	}
	public void setQnaboard_comm_wri(String qnaboard_comm_wri) {
		this.qnaboard_comm_wri = qnaboard_comm_wri;
	}
	public Timestamp getQnaboard_comm_wridate() {
		return qnaboard_comm_wridate;
	}
	public void setQnaboard_comm_wridate(Timestamp qnaboard_comm_wridate) {
		this.qnaboard_comm_wridate = qnaboard_comm_wridate;
	}
	public String getQnaboard_posting_no() {
		return qnaboard_posting_no;
	}
	public void setQnaboard_posting_no(String qnaboard_posting_no) {
		this.qnaboard_posting_no = qnaboard_posting_no;
	}
	
	

}
