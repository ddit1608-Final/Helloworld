package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("indexqna")
@Data
public class IndexQnaVO {
	
	private String qnaboard_posting_no;
	private String qnaboard_title;
	private String qnaboard_board_chu;
	public String getQnaboard_posting_no() {
		return qnaboard_posting_no;
	}
	public void setQnaboard_posting_no(String qnaboard_posting_no) {
		this.qnaboard_posting_no = qnaboard_posting_no;
	}
	public String getQnaboard_title() {
		return qnaboard_title;
	}
	public void setQnaboard_title(String qnaboard_title) {
		this.qnaboard_title = qnaboard_title;
	}
	public String getQnaboard_board_chu() {
		return qnaboard_board_chu;
	}
	public void setQnaboard_board_chu(String qnaboard_board_chu) {
		this.qnaboard_board_chu = qnaboard_board_chu;
	}

	
	
}
