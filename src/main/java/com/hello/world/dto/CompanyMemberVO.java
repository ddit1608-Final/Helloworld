package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("compMem")
public class CompanyMemberVO {

	private String compmem_bsnss_lcse_no; // 사업자 등록번호
	private String compmem_mail; // 이메일
	private String compmem_nm; // 가입자명
	private String compmem_pwd; // 패스워드
	private String compmem_workp; // 근무지
	private String compmem_ceo; // 대표자
	private String compmem_comp_nm; // 회사명
	private String compmem_phn; // 연락처
	private String mem_mail; // 회원메일
	private String mem_nick; // 회원 닉네임
		
	
	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getMem_mail() {
		return mem_mail;
	}

	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}

	public String getCompmem_bsnss_lcse_no() {
		return compmem_bsnss_lcse_no;
	}

	public void setCompmem_bsnss_lcse_no(String compmem_bsnss_lcse_no) {
		this.compmem_bsnss_lcse_no = compmem_bsnss_lcse_no;
	}

	public String getCompmem_mail() {
		return compmem_mail;
	}

	public void setCompmem_mail(String compmem_mail) {
		this.compmem_mail = compmem_mail;
	}

	public String getCompmem_nm() {
		return compmem_nm;
	}

	public void setCompmem_nm(String compmem_nm) {
		this.compmem_nm = compmem_nm;
	}

	public String getCompmem_pwd() {
		return compmem_pwd;
	}

	public void setCompmem_pwd(String compmem_pwd) {
		this.compmem_pwd = compmem_pwd;
	}

	public String getCompmem_workp() {
		return compmem_workp;
	}

	public void setCompmem_workp(String compmem_workp) {
		this.compmem_workp = compmem_workp;
	}

	public String getCompmem_ceo() {
		return compmem_ceo;
	}

	public void setCompmem_ceo(String compmem_ceo) {
		this.compmem_ceo = compmem_ceo;
	}

	public String getCompmem_comp_nm() {
		return compmem_comp_nm;
	}

	public void setCompmem_comp_nm(String compmem_comp_nm) {
		this.compmem_comp_nm = compmem_comp_nm;
	}

	public String getCompmem_phn() {
		return compmem_phn;
	}

	public void setCompmem_phn(String compmem_phn) {
		this.compmem_phn = compmem_phn;
	}
}
