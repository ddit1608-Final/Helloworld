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
	private String compmem_mail;
	
	
	public String getCompmem_mail() {
		return compmem_mail;
	}
	public void setCompmem_mail(String compmem_mail) {
		this.compmem_mail = compmem_mail;
	}
	public String getRctboard_posting_no() {
		return rctboard_posting_no;
	}
	public void setRctboard_posting_no(String rctboard_posting_no) {
		this.rctboard_posting_no = rctboard_posting_no;
	}
	public String getRctboard_crr() {
		return rctboard_crr;
	}
	public void setRctboard_crr(String rctboard_crr) {
		this.rctboard_crr = rctboard_crr;
	}
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
	public String getRctboard_sal() {
		return rctboard_sal;
	}
	public void setRctboard_sal(String rctboard_sal) {
		this.rctboard_sal = rctboard_sal;
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
	public String getRctboard_det_cont() {
		return rctboard_det_cont;
	}
	public void setRctboard_det_cont(String rctboard_det_cont) {
		this.rctboard_det_cont = rctboard_det_cont;
	}
	public String getRctboard_welf_benefit() {
		return rctboard_welf_benefit;
	}
	public void setRctboard_welf_benefit(String rctboard_welf_benefit) {
		this.rctboard_welf_benefit = rctboard_welf_benefit;
	}
	public String getRctboard_phn() {
		return rctboard_phn;
	}
	public void setRctboard_phn(String rctboard_phn) {
		this.rctboard_phn = rctboard_phn;
	}
	public String getRctboard_respsbt() {
		return rctboard_respsbt;
	}
	public void setRctboard_respsbt(String rctboard_respsbt) {
		this.rctboard_respsbt = rctboard_respsbt;
	}
	public String getRctboard_comp_homep() {
		return rctboard_comp_homep;
	}
	public void setRctboard_comp_homep(String rctboard_comp_homep) {
		this.rctboard_comp_homep = rctboard_comp_homep;
	}
	public int getRctboard_hope_emp() {
		return rctboard_hope_emp;
	}
	public void setRctboard_hope_emp(int rctboard_hope_emp) {
		this.rctboard_hope_emp = rctboard_hope_emp;
	}
	public Timestamp getRctboard_wri_date() {
		return rctboard_wri_date;
	}
	public void setRctboard_wri_date(Timestamp rctboard_wri_date) {
		this.rctboard_wri_date = rctboard_wri_date;
	}
	public String getCompmem_bsnss_lcse_no() {
		return compmem_bsnss_lcse_no;
	}
	public void setCompmem_bsnss_lcse_no(String compmem_bsnss_lcse_no) {
		this.compmem_bsnss_lcse_no = compmem_bsnss_lcse_no;
	}
	public String getRctboard_title() {
		return rctboard_title;
	}
	public void setRctboard_title(String rctboard_title) {
		this.rctboard_title = rctboard_title;
	}
	public String getCompmem_comp_nm() {
		return compmem_comp_nm;
	}
	public void setCompmem_comp_nm(String compmem_comp_nm) {
		this.compmem_comp_nm = compmem_comp_nm;
	}
	
	

}
