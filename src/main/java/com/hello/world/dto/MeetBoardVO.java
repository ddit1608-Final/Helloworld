package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("meetboard")
@Data
public class MeetBoardVO {

	private String meet_board_posting_no; // 모임게시판 게시글 번호
	private String mem_mail; // 멤버 테이블 아이디->닉네임 가져올것
	private String mem_nick; // 가져왔다 씨부럴ㅇ닉네임
	private String meet_board_title; // 모임게시판 제목
	private int meet_board_hits; // 모임게시판 조회수
	private String meet_board_cont; // 모임게시판 내용
	private Timestamp meet_board_wridate; // 모임게시판 작성 일자
	private String flow_code; // 말머리
	private String meet_board_pwd;
	private String key;
	private String mem_phn;


}
