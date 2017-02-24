package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("RctBoard")
@Data
public class RctBoardVO {
	
	private String rctboard_posting_no;
	private String rctboard_crr;
	private String rctboard_acdmcr;
	private String rctboard_year_sal;
	private String rctboard_emp_kind;
	private String rctboard_sal;
	private String rctboard_workp;
	private String rctboard_work_time;
	private String rctboard_det_cont;
	private String rctboard_welf_benefit;
	private String rctboard_phn;
	private String rctboard_respsbt;
	private String rctboard_comp_homep;
	private int rctboard_hope_emp;
	private Timestamp rctboard_wri_date;
	private String compmem_bsnss_lcse_no;
	private String rctboard_title;
	private String compmem_comp_nm;

}
