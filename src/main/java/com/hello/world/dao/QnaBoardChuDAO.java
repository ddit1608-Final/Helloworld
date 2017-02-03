package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.QnaBoardChuVO;
import com.hello.world.dto.QnaBoardCommVO;

public interface QnaBoardChuDAO {
	
	public void updateQnaBoardChuComm(QnaBoardChuVO qnaBoardChuVO)throws SQLException;
	public QnaBoardChuVO listQnaBoardChu(String qnaboard_ans_code)throws SQLException;

}