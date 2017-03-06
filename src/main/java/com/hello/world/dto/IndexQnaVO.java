package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("indexqna")
@Data
public class IndexQnaVO {
	
	private String qnaboard_posting_no;
	private String qnaboard_title;
	private String qnaboard_board_chu;

}
