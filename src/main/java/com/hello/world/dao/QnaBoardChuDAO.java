package com.hello.world.dao;

import java.sql.SQLException;

import com.hello.world.dto.QnaBoardChuVO;

public interface QnaBoardChuDAO {
	
	public int insertQnaBoardChu(QnaBoardChuVO qnaBoardChuVO)throws SQLException;

}
