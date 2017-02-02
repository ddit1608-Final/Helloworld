package com.hello.world.dao;

import java.sql.SQLException;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.QnaBoardChuVO;

public interface QnaBoardChuDAO {
	
	public void updateQnaBoardChuComm(QnaBoardChuVO qnaBoardChuVO)throws SQLException;

}
