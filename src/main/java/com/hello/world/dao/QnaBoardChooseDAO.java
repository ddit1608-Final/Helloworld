package com.hello.world.dao;

import java.sql.SQLException;

import com.hello.world.dto.QnaBoardChooseVO;

public interface QnaBoardChooseDAO {
	
	public int insertQnaBoardChoose(QnaBoardChooseVO qnaBoardChooseVO)throws SQLException;
	public QnaBoardChooseVO listQnaBoardChoose(String qnaboard_ans_code)throws SQLException;
}
