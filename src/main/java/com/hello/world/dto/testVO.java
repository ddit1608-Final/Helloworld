package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("testVO")
@Data
public class testVO {

	
	private String type;
	private String key;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
	
	
	
}
