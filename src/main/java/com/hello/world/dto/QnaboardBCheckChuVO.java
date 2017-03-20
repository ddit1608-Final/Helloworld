package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;



@Alias("qnabcheckchu")
@Data
public class QnaboardBCheckChuVO {
	
	private String qnaboard_posting_no;
	private String mem_mail;
	public String getQnaboard_posting_no() {
		return qnaboard_posting_no;
	}
	public void setQnaboard_posting_no(String qnaboard_posting_no) {
		this.qnaboard_posting_no = qnaboard_posting_no;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	
	
	
}