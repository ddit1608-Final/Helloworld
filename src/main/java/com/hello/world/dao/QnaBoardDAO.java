package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.testVO;

public interface QnaBoardDAO {
	
	public void insertQnaBoard(QnaBoardVO qnaBoardVO)throws SQLException;
	public ArrayList<QnaBoardVO> listAllQnaBoard(int startRow, testVO testVO, int counts)throws SQLException;
	public int totalRecord(testVO testVO)throws SQLException;
	public QnaBoardVO getQnaDetail(String qnaboard_posting_no)throws SQLException;

}
