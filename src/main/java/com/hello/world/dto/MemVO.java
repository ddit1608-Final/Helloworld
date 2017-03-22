package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("mem")
public class MemVO {
	private String mem_mail; // 이메일(아이디)
	private String mem_nm; // 이름
	private String mem_pw; // 패스워드
	private String mem_phn; // 연락처(휴대폰)
	private String mem_addr; // 주소
	private String mem_addr_detail; // 주소
	private int mem_sex; // 성별
	private int mem_lang; // 사용언어
	private String mem_nick; // 닉네임
	private Timestamp mem_join_date; // 가입날짜
	private String addr_zipnum; // 우편번호
	private String mem_grade_code; // 회원등급
	private String crr_code; // 경력코드 몇년차?
	private String workex_code; //
	
	
	public String getMem_addr_detail() {
		return mem_addr_detail;
	}

	public void setMem_addr_detail(String mem_addr_detail) {
		this.mem_addr_detail = mem_addr_detail;
	}

	public String getMem_mail() {
		return mem_mail;
	}

	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}

	public String getMem_nm() {
		return mem_nm;
	}

	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_phn() {
		return mem_phn;
	}

	public void setMem_phn(String mem_phn) {
		this.mem_phn = mem_phn;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public int getMem_sex() {
		return mem_sex;
	}

	public void setMem_sex(int mem_sex) {
		this.mem_sex = mem_sex;
	}

	public int getMem_lang() {
		return mem_lang;
	}

	public void setMem_lang(int mem_lang) {
		this.mem_lang = mem_lang;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public Timestamp getMem_join_date() {
		return mem_join_date;
	}

	public void setMem_join_date(Timestamp mem_join_date) {
		this.mem_join_date = mem_join_date;
	}

	public String getAddr_zipnum() {
		return addr_zipnum;
	}

	public void setAddr_zipnum(String addr_zipnum) {
		this.addr_zipnum = addr_zipnum;
	}

	public String getMem_grade_code() {
		return mem_grade_code;
	}

	public void setMem_grade_code(String mem_grade_code) {
		this.mem_grade_code = mem_grade_code;
	}

	public String getCrr_code() {
		return crr_code;
	}

	public void setCrr_code(String crr_code) {
		this.crr_code = crr_code;
	}

	public String getWorkex_code() {
		return workex_code;
	}

	public void setWorkex_code(String workex_code) {
		this.workex_code = workex_code;
	}

}
