package com.hello.world.dto;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("address")
@Data
public class AddressVO {
	private String addr_zipNum; // 우편번호
	private String addr_sido; // 시
	private String addr_gugun; // 구
	private String addr_dong; // 동
	private String addr_zip_code; // 우편코드
	private String addr_bunji; // 번지
	public String getAddr_zipNum() {
		return addr_zipNum;
	}
	public void setAddr_zipNum(String addr_zipNum) {
		this.addr_zipNum = addr_zipNum;
	}
	public String getAddr_sido() {
		return addr_sido;
	}
	public void setAddr_sido(String addr_sido) {
		this.addr_sido = addr_sido;
	}
	public String getAddr_gugun() {
		return addr_gugun;
	}
	public void setAddr_gugun(String addr_gugun) {
		this.addr_gugun = addr_gugun;
	}
	public String getAddr_dong() {
		return addr_dong;
	}
	public void setAddr_dong(String addr_dong) {
		this.addr_dong = addr_dong;
	}
	public String getAddr_zip_code() {
		return addr_zip_code;
	}
	public void setAddr_zip_code(String addr_zip_code) {
		this.addr_zip_code = addr_zip_code;
	}
	public String getAddr_bunji() {
		return addr_bunji;
	}
	public void setAddr_bunji(String addr_bunji) {
		this.addr_bunji = addr_bunji;
	}
	
	

}
