package com.hello.world.dto;


import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("notice")
@Data
public class NoticeVO {
	
	

	private String notice_id;
	private String notice_title;
	private String notice_cont;
	private String notice_sort_code;
	private String mem_mail;
	private String mem_nick;
	private Timestamp notice_wridate;
	public String getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_cont() {
		return notice_cont;
	}
	public void setNotice_cont(String notice_cont) {
		this.notice_cont = notice_cont;
	}
	public String getNotice_sort_code() {
		return notice_sort_code;
	}
	public void setNotice_sort_code(String notice_sort_code) {
		this.notice_sort_code = notice_sort_code;
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
	public Timestamp getNotice_wridate() {
		return notice_wridate;
	}
	public void setNotice_wridate(Timestamp notice_wridate) {
		this.notice_wridate = notice_wridate;
	}

	
	
}
