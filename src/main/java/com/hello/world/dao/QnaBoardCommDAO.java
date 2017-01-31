package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.QnaBoardCommVO;

public interface QnaBoardCommDAO {
	
	public int insertQnaBoardComm(QnaBoardCommVO qnaBoardCommVO)throws SQLException;
	public ArrayList<QnaBoardCommVO> listQnaBoardComm(String qnaboard_posting_no)throws SQLException;
	public void deleteQnaBoardComm(String qnaBoardCommVO)throws SQLException;
	public void updateQnaBoardComm(QnaBoardCommVO qnaBoardCommVO)throws SQLException;

}
