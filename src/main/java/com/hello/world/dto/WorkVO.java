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
	
	
}
