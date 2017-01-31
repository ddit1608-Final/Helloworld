package com.hello.world.dao;

import java.sql.SQLException;

import com.hello.world.dto.QnaBoardVO;

public interface QnaBoardDAO {
	
	public void insertQnaBoard(QnaBoardVO qnaBoardVO)throws SQLException;

}
