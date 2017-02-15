package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("dog")
@Data
public class DogBoardVO {
	
	private String dsboard_posting_no; // 게시글 번호
	private String dsboard_title;	  // 게시글 제목
	private String dsboard_cont;		  // 게시글 내용
	private Timestamp dsboard_wridate; // 게시글 날짜
	private int dsboard_hits;		  // 게시글 조회수
	private String dsboard_pwd;		  // 게시글 비번
	private String mem_mail;			  // 작성자 메일
	private String mem_nick;			  // 작성자 메일
	private String mem_phn;				  // 작성자 연락처
	private String type_key; 			  // 게시글 말머리
	private String type_value;
		
	
}