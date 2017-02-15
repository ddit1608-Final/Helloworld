package com.hello.world.dao;

import java.sql.SQLException;

import com.hello.world.dto.MeetBoardVO;
import com.hello.world.dto.QnaBoardCheckChuVO;
import com.hello.world.dto.QnaBoardChuVO;

public interface QnaBoardChuDAO {
	
	public void updateQnaBoardChuComm(QnaBoardChuVO qnaBoardChuVO)throws SQLException;
	public void updateQnaBoardBChuComm(QnaBoardChuVO qnaBoardChuVO)throws SQLException;
	public QnaBoardChuVO listQnaBoardChu(String qnaboard_ans_code)throws SQLException;
	public void insertCheckChu(QnaBoardCheckChuVO qnaBoardCheckChuVO)throws SQLException;
	public QnaBoardCheckChuVO CheckChu(String qnaboard_ans_code)throws SQLException;

}