package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;

@Alias("rctSearchVO")
public class rctSearchVO {

	private String area; // 지역 ㅇ
	private String lan; // 언어 ㅇ
	private String comg; // 경력 ㅇ
	private String grade; // 학력 ㅇ
	private String sal; // 연봉 ㅇ
	private String comp_name; // 회사이름 ㅇ
	private String title; // 제목 
	

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		this.lan = lan;
	}

	public String getComg() {
		return comg;
	}

	public void setComg(String comg) {
		this.comg = comg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

}
