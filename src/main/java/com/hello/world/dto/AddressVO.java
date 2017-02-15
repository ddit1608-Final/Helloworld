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

}
