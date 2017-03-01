package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("qnaboard")
@Data
public class QnaBoardVO {
	
	private String qnaboard_posting_no; //게시글 번호
	private String qnaboard_title; //게시글 제목
	private String qnaboard_cont; // 게시글 내용
	private Timestamp qnaboard_wridate; // 게시글 작성날짜
	private int qnaboard_hits; // 게시글 조회수
	private String qnaboard_pwd; // 게시글 비밀번호
	private String mem_mail; // 회원아이디
	private String mem_nick; // 회원 닉네임
	private String mem_phn;
	
}
