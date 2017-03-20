package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("Scrap")
@Data
public class ScrapVO {

	private String scrap_no;
	private String scrap_cont;
	private String mem_mail;
	public String getScrap_no() {
		return scrap_no;
	}
	public void setScrap_no(String scrap_no) {
		this.scrap_no = scrap_no;
	}
	public String getScrap_cont() {
		return scrap_cont;
	}
	public void setScrap_cont(String scrap_cont) {
		this.scrap_cont = scrap_cont;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	
	
}
