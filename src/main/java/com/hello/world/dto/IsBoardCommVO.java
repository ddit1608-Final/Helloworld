package com.hello.world.dto;

import java.sql.Timestamp;
import java.util.Date;

public class IsBoardCommVO {
	
	private String ifshrboard_ans_code;			// 답변코드 seq 
	private String ifshrboard_posting_no;		// 해당게시글 번호(seq)
	private String freeboard_comm_cont;			// 답변 내용
	private String ifshrboard_comm_wri;			// 답변 작성자 nick 가져올것 == mem_mail
	private Timestamp ifshrboard_comm_wridate;		// 답변 작성날짜	
	private String mem_nick;
	
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
	public String getFreeboard_comm_cont() {
		return freeboard_comm_cont;
	}
	public void setFreeboard_comm_cont(String freeboard_comm_cont) {
		this.freeboard_comm_cont = freeboard_comm_cont;
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
	@Override
	public String toString() {
		return "IsBoardCommVO [ifshrboard_ans_code=" + ifshrboard_ans_code
				+ ", ifshrboard_posting_no=" + ifshrboard_posting_no
				+ ", freeboard_comm_cont=" + freeboard_comm_cont
				+ ", ifshrboard_comm_wri=" + ifshrboard_comm_wri
				+ ", ifshrboard_comm_wridate=" + ifshrboard_comm_wridate
				+ ", mem_nick=" + mem_nick + "]";
	}					
	
	
	
}