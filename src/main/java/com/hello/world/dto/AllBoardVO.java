package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;

/**
 * 
 * @author PC23
 *		
 *
 *
 */
@Alias("AllBoard")
public class AllBoardVO {

	/*private String freeboard_title;
	private Timestamp freeboard_wridate;
	private String freeboard_cont;
	
	private String ifshrboard_title;
	private Timestamp ifshrboard_wridate;
	private String ifshrboard_cont;
	
	private String dsboard_title;
	private Timestamp dsboard_wridate;
	private String dsboard_cont;
	
	private String qnaboard_title;
	private Timestamp qnaboard_wridate;
	private String qnaboard_cont;
	
	private String meet_board_title;
	private Timestamp meet_board_wridate;
	private String meet_board_cont;
	
	private String mem_nick;
	private String mem_mail;*/
	private String title;
	private String cont;
	private Timestamp wridate;
	private String typ;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Timestamp getWridate() {
		return wridate;
	}
	public void setWridate(Timestamp wridate) {
		this.wridate = wridate;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	
	
	
	
	
	
	
	
	
}
