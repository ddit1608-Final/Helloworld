package com.hello.world.dto;

import java.sql.Timestamp;

public class PointVO {
	private String point_code;
	private String point;
	private Timestamp point_save_date;
	private String mem_mail;

	public String getPoint_code() {
		return point_code;
	}

	public void setPoint_code(String point_code) {
		this.point_code = point_code;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public Timestamp getPoint_save_date() {
		return point_save_date;
	}

	public void setPoint_save_date(Timestamp point_save_date) {
		this.point_save_date = point_save_date;
	}

	public String getMem_mail() {
		return mem_mail;
	}

	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}

}
