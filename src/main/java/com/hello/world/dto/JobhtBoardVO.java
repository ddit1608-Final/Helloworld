package com.hello.world.dto;

import java.sql.Timestamp;

public class JobhtBoardVO {
	
	private String mem_mail; // 회원 메일
	private String jobhtboard_homep; 
	private String jobhtboard_hope_sal;
	private String jobhtboard_hope_workp;
	private String jobhtboard_vltr_kind;
	private String jobhtboard_posting_no;
	private String resm_id;
	private Timestamp jobhtboard_wri_date;
	private String com_use_abil_code;
	private String lang_abil_code;
	private String jobhtboard_title;
	
	
	public String getJobhtboard_title() {
		return jobhtboard_title;
	}
	public void setJobhtboard_title(String jobhtboard_title) {
		this.jobhtboard_title = jobhtboard_title;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getJobhtboard_homep() {
		return jobhtboard_homep;
	}
	public void setJobhtboard_homep(String jobhtboard_homep) {
		this.jobhtboard_homep = jobhtboard_homep;
	}
	public String getJobhtboard_hope_sal() {
		return jobhtboard_hope_sal;
	}
	public void setJobhtboard_hope_sal(String jobhtboard_hope_sal) {
		this.jobhtboard_hope_sal = jobhtboard_hope_sal;
	}
	public String getJobhtboard_hope_workp() {
		return jobhtboard_hope_workp;
	}
	public void setJobhtboard_hope_workp(String jobhtboard_hope_workp) {
		this.jobhtboard_hope_workp = jobhtboard_hope_workp;
	}
	public String getJobhtboard_vltr_kind() {
		return jobhtboard_vltr_kind;
	}
	public void setJobhtboard_vltr_kind(String jobhtboard_vltr_kind) {
		this.jobhtboard_vltr_kind = jobhtboard_vltr_kind;
	}
	public String getJobhtboard_posting_no() {
		return jobhtboard_posting_no;
	}
	public void setJobhtboard_posting_no(String jobhtboard_posting_no) {
		this.jobhtboard_posting_no = jobhtboard_posting_no;
	}
	public String getResm_id() {
		return resm_id;
	}
	public void setResm_id(String resm_id) {
		this.resm_id = resm_id;
	}
	public Timestamp getJobhtboard_wri_date() {
		return jobhtboard_wri_date;
	}
	public void setJobhtboard_wri_date(Timestamp jobhtboard_wri_date) {
		this.jobhtboard_wri_date = jobhtboard_wri_date;
	}
	public String getCom_use_abil_code() {
		return com_use_abil_code;
	}
	public void setCom_use_abil_code(String com_use_abil_code) {
		this.com_use_abil_code = com_use_abil_code;
	}
	public String getLang_abil_code() {
		return lang_abil_code;
	}
	public void setLang_abil_code(String lang_abil_code) {
		this.lang_abil_code = lang_abil_code;
	}
	@Override
	public String toString() {
		return "JobhtBoardVO [mem_mail=" + mem_mail + ", jobhtboard_homep="
				+ jobhtboard_homep + ", jobhtboard_hope_sal="
				+ jobhtboard_hope_sal + ", jobhtboard_hope_workp="
				+ jobhtboard_hope_workp + ", jobhtboard_vltr_kind="
				+ jobhtboard_vltr_kind + ", jobhtboard_posting_no="
				+ jobhtboard_posting_no + ", resm_id=" + resm_id
				+ ", jobhtboard_wri_date=" + jobhtboard_wri_date
				+ ", com_use_abil_code=" + com_use_abil_code
				+ ", lang_abil_code=" + lang_abil_code + "]";
	}
	
	
	
	
	

}
