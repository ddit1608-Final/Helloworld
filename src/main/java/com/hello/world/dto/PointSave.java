package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("pointsave")
@Data
public class PointSave {
	
	private String mem_mail;
	private String point;
	private String point_cont;
	private Timestamp point_save_date;
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getPoint_cont() {
		return point_cont;
	}
	public void setPoint_cont(String point_cont) {
		this.point_cont = point_cont;
	}
	public Timestamp getPoint_save_date() {
		return point_save_date;
	}
	public void setPoint_save_date(Timestamp point_save_date) {
		this.point_save_date = point_save_date;
	}
	
	
}
