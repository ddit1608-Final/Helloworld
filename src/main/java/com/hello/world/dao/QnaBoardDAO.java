package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.QnaBoardVO;

public interface QnaBoardDAO {
	
	public void insertQnaBoard(QnaBoardVO qnaBoardVO)throws SQLException;
	public ArrayList<QnaBoardVO> listAllQnaBoard(int startRow, String qnaboard_title, int counts)throws SQLException;
	public int totalRecord(String name)throws SQLException;
	public QnaBoardVO getQnaDetail(String qnaboard_posting_no)throws SQLException;

}
