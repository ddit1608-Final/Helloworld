package com.hello.world.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
// 워크넷에서 return되는 값이 XML으로 이루어져있으므로
@XmlRootElement(name = "wantedRoot")
@Data
public class WantedRoot {
	private int total; 					// 총건수
	private int startPage;				// 기본값 1, 최대 1000 검색의 시작위치를 지정 할 수 있습니다.
	private int display;				// 출력건수, 기본값 10
	
	// 수많은 구인게시물을 리스트에 담고
	@XmlElement(name="wanted")
	private List<Wanted> wanted;
	
	@XmlRootElement(name="wanted")
	@Data
	public static class Wanted{
		private String wantedAuthNo; 	// 구인인증번호 ==> 체크박스 벨류로 사용중
		private String company; 		// 회사명
		private String title;			// 채용제목
		private String salTpNm;			// 임금형태 
		private String sal; 			// 급여
		private String region; 			// 근무지역
		private String holidayTpNm;		// 근무형태 
		private String minEdubg;		// 최소학력 
		private String maxEdubg;		// 최대학력 
		private String career; 			// 경력
		private String regDt; 			// 등록일자
		private String closeDt; 		// 마감일자
		private String infoSvc; 		// 정보제공처
		private String wantedInfoUrl; 	// 잡로봇 채용정보URL
		private String zipCd; 			// 근무지 우편주소
		private String strtnmCd; 		// 근무지 도로명주소
		private String basicAddr;		// 근무지 기본주소
		private String detailAddr; 		// 근무지 상세주소
	}
}
