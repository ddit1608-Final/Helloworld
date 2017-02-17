package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;



@Alias("qnabcheckchu")
@Data
public class QnaboardBCheckChuVO {
	
	private String qnaboard_posting_no;
	private String mem_mail;

}
