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

}
