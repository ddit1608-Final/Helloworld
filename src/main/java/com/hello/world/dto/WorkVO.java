package com.hello.world.dto;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import kr.or.ddit.commons.ibatis.Alias;


import lombok.Data;
@Alias("work")
@Data
public class WorkVO {
	private String mem_mail;
	@JsonProperty("id")
	private String wantedAuthNo; 	// 구인인증번호 ==> 체크박스 벨류로 사용중1
	@JsonProperty("name")
	private String company; 		// 회사명1
	private String title;			// 채용제목1
	private String salTpNm;			// 임금형태 1
	private String sal; 			// 급여1
	private String region; 			// 근무지역1
	private String holidayTpNm;		// 근무형태 
	private String minEdubg;		// 최소학력 
	private String maxEdubg;		// 최대학력 
	private String career; 			// 경력1
	private String regDt; 			// 등록일자1
	private String closeDt; 		// 마감일자1
	private String infoSvc; 		// 정보제공처
	private String wantedInfoUrl; 	// 잡로봇 채용정보URL
	private String zipCd; 			// 근무지 우편주소
	private String strtnmCd; 		// 근무지 도로명주소
	private String basicAddr;		// 근무지 기본주소
	private String detailAddr; 		// 근무지 상세주소
	public String getMem_mail() {
		return mem_mail;
	}
	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}
	public String getWantedAuthNo() {
		return wantedAuthNo;
	}
	public void setWantedAuthNo(String wantedAuthNo) {
		this.wantedAuthNo = wantedAuthNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSalTpNm() {
		return salTpNm;
	}
	public void setSalTpNm(String salTpNm) {
		this.salTpNm = salTpNm;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getHolidayTpNm() {
		return holidayTpNm;
	}
	public void setHolidayTpNm(String holidayTpNm) {
		this.holidayTpNm = holidayTpNm;
	}
	public String getMinEdubg() {
		return minEdubg;
	}
	public void setMinEdubg(String minEdubg) {
		this.minEdubg = minEdubg;
	}
	public String getMaxEdubg() {
		return maxEdubg;
	}
	public void setMaxEdubg(String maxEdubg) {
		this.maxEdubg = maxEdubg;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getCloseDt() {
		return closeDt;
	}
	public void setCloseDt(String closeDt) {
		this.closeDt = closeDt;
	}
	public String getInfoSvc() {
		return infoSvc;
	}
	public void setInfoSvc(String infoSvc) {
		this.infoSvc = infoSvc;
	}
	public String getWantedInfoUrl() {
		return wantedInfoUrl;
	}
	public void setWantedInfoUrl(String wantedInfoUrl) {
		this.wantedInfoUrl = wantedInfoUrl;
	}
	public String getZipCd() {
		return zipCd;
	}
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	public String getStrtnmCd() {
		return strtnmCd;
	}
	public void setStrtnmCd(String strtnmCd) {
		this.strtnmCd = strtnmCd;
	}
	public String getBasicAddr() {
		return basicAddr;
	}
	public void setBasicAddr(String basicAddr) {
		this.basicAddr = basicAddr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	
	
	
	
}
