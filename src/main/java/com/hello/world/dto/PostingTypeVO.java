package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("tVO")
public class PostingTypeVO {
	
	
	// 정보공유 게시판에서 말머리 쓰기위해서
	
	private String type_key;
	private String type_value;
	
	public String getType_key() {
		return type_key;
	}
	public void setType_key(String type_key) {
		this.type_key = type_key;
	}
	public String getType_value() {
		return type_value;
	}
	public void setType_value(String type_value) {
		this.type_value = type_value;
	}
	
	
	
	
}
