package com.hello.world.dto;

import java.sql.Timestamp;

import kr.or.ddit.commons.ibatis.Alias;
import lombok.Data;

@Alias("pointsave")
@Data
public class PointSave {
	
	private String mem_mail;
	private String point;
	private String point_cont;
	private Timestamp point_save_date;

}
