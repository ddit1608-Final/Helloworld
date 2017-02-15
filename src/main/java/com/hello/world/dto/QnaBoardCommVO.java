package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("qnacomm")
public class QnaBoardCommVO {
	
	private String qnaboard_ans_code; //댓글 번호
	private String qnaboard_comm_cont; // 댓글 내용
	private String qnaboard_comm_wri; // 댓글 작성자
	private Timestamp qnaboard_comm_wridate; // 댓글 작성날짜
	private String qnaboard_posting_no; // 게시글 번호
	
	
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
