package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("level")
public class IsBoardLevelVO {

	private String crr_key;
	private String crr_value;
	
	public String getCrr_key() {
		return crr_key;
	}
	public void setCrr_key(String crr_key) {
		this.crr_key = crr_key;
	}
	public String getCrr_value() {
		return crr_value;
	}
	public void setCrr_value(String crr_value) {
		this.crr_value = crr_value;
	}
	
	
	
	
}
