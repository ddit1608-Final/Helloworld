package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Scrap")
@Data
public class ScrapVO {

	private String scrap_no;
	private String scrap_cont;
	private String mem_mail;
	
	
}
