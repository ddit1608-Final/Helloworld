package com.hello.world.dto;

import java.util.Date;

public class FreeBoardCommVO {
	
	private String freeboard_ans_code;			// 답변코드 seq 
	private String freeboard_posting_no;		// 해당게시글 번호(seq)
	private String freeboard_comm_cont;			// 답변 내용
	private String freeboard_comm_wri;			// 답변 작성자 nick 가져올것 == mem_mail
	private Date freeboard_comm_wridate;		// 답변 작성날짜	
	//private String mem_nick;					// 답변 작성자 nick
	
	
	
	/*public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}*/
	public String getFreeboard_ans_code() {
		return freeboard_ans_code;
	}
	public void setFreeboard_ans_code(String freeboard_ans_code) {
		this.freeboard_ans_code = freeboard_ans_code;
	}
	public String getFreeboard_posting_no() {
		return freeboard_posting_no;
	}
	public void setFreeboard_posting_no(String freeboard_posting_no) {
		this.freeboard_posting_no = freeboard_posting_no;
	}
	public String getFreeboard_comm_cont() {
		return freeboard_comm_cont;
	}
	public void setFreeboard_comm_cont(String freeboard_comm_cont) {
		this.freeboard_comm_cont = freeboard_comm_cont;
	}
	public String getFreeboard_comm_wri() {
		return freeboard_comm_wri;
	}
	public void setFreeboard_comm_wri(String freeboard_comm_wri) {
		this.freeboard_comm_wri = freeboard_comm_wri;
	}
	public Date getFreeboard_comm_wridate() {
		return freeboard_comm_wridate;
	}
	public void setFreeboard_comm_wridate(Date freeboard_comm_wridate) {
		this.freeboard_comm_wridate = freeboard_comm_wridate;
	}
	/*public FreeBoardCommVO(String freeboard_ans_code,
			String freeboard_posting_no, String freeboard_comm_cont,
			String freeboard_comm_wri, Date freeboard_comm_wridate,
			String mem_nick) {
		super();
		this.freeboard_ans_code = freeboard_ans_code;
		this.freeboard_posting_no = freeboard_posting_no;
		this.freeboard_comm_cont = freeboard_comm_cont;
		this.freeboard_comm_wri = freeboard_comm_wri;
		this.freeboard_comm_wridate = freeboard_comm_wridate;
		this.mem_nick = mem_nick;
	}
	@Override
	public String toString() {
		return "FreeBoardCommVO [freeboard_ans_code=" + freeboard_ans_code
				+ ", freeboard_posting_no=" + freeboard_posting_no
				+ ", freeboard_comm_cont=" + freeboard_comm_cont
				+ ", freeboard_comm_wri=" + freeboard_comm_wri
				+ ", freeboard_comm_wridate=" + freeboard_comm_wridate
				+ ", mem_nick=" + mem_nick + "]";
	}*/
	
	
	
	
	
}
