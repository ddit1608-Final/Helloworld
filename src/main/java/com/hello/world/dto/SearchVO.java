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
	public String getRctboard_acdmcr() {
		return rctboard_acdmcr;
	}
	public void setRctboard_acdmcr(String rctboard_acdmcr) {
		this.rctboard_acdmcr = rctboard_acdmcr;
	}
	public String getRctboard_year_sal() {
		return rctboard_year_sal;
	}
	public void setRctboard_year_sal(String rctboard_year_sal) {
		this.rctboard_year_sal = rctboard_year_sal;
	}
	public String getRctboard_emp_kind() {
		return rctboard_emp_kind;
	}
	public void setRctboard_emp_kind(String rctboard_emp_kind) {
		this.rctboard_emp_kind = rctboard_emp_kind;
	}
	public String getRctboard_workp() {
		return rctboard_workp;
	}
	public void setRctboard_workp(String rctboard_workp) {
		this.rctboard_workp = rctboard_workp;
	}
	public String getRctboard_work_time() {
		return rctboard_work_time;
	}
	public void setRctboard_work_time(String rctboard_work_time) {
		this.rctboard_work_time = rctboard_work_time;
	}
	public String getRctboard_title() {
		return rctboard_title;
	}
	public void setRctboard_title(String rctboard_title) {
		this.rctboard_title = rctboard_title;
	}
	
	
	
}
