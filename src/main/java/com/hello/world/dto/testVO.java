package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("testVO")
@Data
public class testVO {

	
	private String type;
	private String key;
	
	
	
}
