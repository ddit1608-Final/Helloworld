package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("cstBoard_Counsel")
public class CstBoardCounselVO {
	private String cstboard_counsel_posting_no;
	private String cstboard_counsel_title;
	private String cstboard_counsel_cont;
	private Timestamp cstboard_counsel_wridate;
	private String mem_mail;
	private String flow_code;

	public String getCstboard_counsel_posting_no() {
		return cstboard_counsel_posting_no;
	}

	public void setCstboard_counsel_posting_no(
			String cstboard_counsel_posting_no) {
		this.cstboard_counsel_posting_no = cstboard_counsel_posting_no;
	}

	public String getCstboard_counsel_title() {
		return cstboard_counsel_title;
	}

	public void setCstboard_counsel_title(String cstboard_counsel_title) {
		this.cstboard_counsel_title = cstboard_counsel_title;
	}

	public String getCstboard_counsel_cont() {
		return cstboard_counsel_cont;
	}

	public void setCstboard_counsel_cont(String cstboard_counsel_cont) {
		this.cstboard_counsel_cont = cstboard_counsel_cont;
	}

	public Timestamp getCstboard_counsel_wridate() {
		return cstboard_counsel_wridate;
	}

	public void setCstboard_counsel_wridate(Timestamp cstboard_counsel_wridate) {
		this.cstboard_counsel_wridate = cstboard_counsel_wridate;
	}

	public String getMem_mail() {
		return mem_mail;
	}

	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}

	public String getFlow_code() {
		return flow_code;
	}

	public void setFlow_code(String flow_code) {
		this.flow_code = flow_code;
	}

}
