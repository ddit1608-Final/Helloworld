package com.hello.world.dao;

import java.sql.SQLException;

import java.util.ArrayList;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.QnaBoardBChuVO;

public interface QnaboardBChuDAO {
	
	public void updateQnaBoardChuComm(QnaBoardBChuVO qnaBoardBChuVO)throws SQLException;
	public void updateQnaBoardBChuComm(QnaBoardBChuVO qnaBoardBChuVO)throws SQLException;
	public QnaBoardBChuVO listQnaBoardBChu(String qnaboard_posting_no)throws SQLException;
	public ArrayList<QnaBoardBChuVO> listAllQnaBChuBoard()throws SQLException;
}
