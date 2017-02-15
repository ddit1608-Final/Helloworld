package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("crr")
public class CrrVO {
	private String crr_id;
	private String crr_nm;
	private String crr_code;

	public String getCrr_id() {
		return crr_id;
	}

	public void setCrr_id(String crr_id) {
		this.crr_id = crr_id;
	}

	public String getCrr_nm() {
		return crr_nm;
	}

	public void setCrr_nm(String crr_nm) {
		this.crr_nm = crr_nm;
	}

	public String getCrr_code() {
		return crr_code;
	}

	public void setCrr_code(String crr_code) {
		this.crr_code = crr_code;
	}

}
