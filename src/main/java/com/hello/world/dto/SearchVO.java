package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;


@Alias("searchVO")
@Data
public class SearchVO {
	
	private String rctboard_acdmcr;
	private String rctboard_year_sal;
	private String rctboard_emp_kind;
	private String rctboard_workp;
	private String rctboard_work_time;
	private String rctboard_title;

}
