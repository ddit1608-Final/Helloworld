package com.hello.world.dto;

import java.sql.Timestamp;

public class ResmVO {
	
	private String resm_id; //이력서아이디
	private String mem_mail; // 이메일
	private String sidn_code; // 자기소개서 코드
	private String lcse_code; // 이력서 코드
	private String acdmcr_code; // 학력코드
	private String idpic_code; // 증명사진코드
	private String resm_regno; // 주민등록번호
	private String milt_code; // 병역
	private String resm_hob; // 취미
	private String resm_like; // 특기
	private Timestamp resm_wri_date; // 작성날짜
	
	
	public String getResm_id() {
		return resm_id;
	}
	public void setResm_id(String resm_id) {
		this.resm_id = resm_id;
	}
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getSidn_code() {
		return sidn_code;
	}
	public void setSidn_code(String sidn_code) {
		this.sidn_code = sidn_code;
	}
	public String getLcse_code() {
		return lcse_code;
	}
	public void setLcse_code(String lcse_code) {
		this.lcse_code = lcse_code;
	}
	public String getAcdmcr_code() {
		return acdmcr_code;
	}
	public void setAcdmcr_code(String acdmcr_code) {
		this.acdmcr_code = acdmcr_code;
	}
	public String getIdpic_code() {
		return idpic_code;
	}
	public void setIdpic_code(String idpic_code) {
		this.idpic_code = idpic_code;
	}
	public String getResm_regno() {
		return resm_regno;
	}
	public void setResm_regno(String resm_regno) {
		this.resm_regno = resm_regno;
	}
	public String getMilt_code() {
		return milt_code;
	}
	public void setMilt_code(String milt_code) {
		this.milt_code = milt_code;
	}
	public String getResm_hob() {
		return resm_hob;
	}
	public void setResm_hob(String resm_hob) {
		this.resm_hob = resm_hob;
	}
	public String getResm_like() {
		return resm_like;
	}
	public void setResm_like(String resm_like) {
		this.resm_like = resm_like;
	}
	public Timestamp getResm_wri_date() {
		return resm_wri_date;
	}
	public void setResm_wri_date(Timestamp resm_wri_date) {
		this.resm_wri_date = resm_wri_date;
	}
	
	
	@Override
	public String toString() {
		return "ResmVO [resm_id=" + resm_id + ", mem_mail=" + mem_mail
				+ ", sidn_code=" + sidn_code + ", lcse_code=" + lcse_code
				+ ", acdmcr_code=" + acdmcr_code + ", idpic_code=" + idpic_code
				+ ", resm_regno=" + resm_regno + ", milt_code=" + milt_code
				+ ", resm_hob=" + resm_hob + ", resm_like=" + resm_like
				+ ", resm_wri_date=" + resm_wri_date + "]";
	}
	
	
	
		
}
