package com.hello.world.service;

import java.sql.SQLException;

import com.hello.world.dao.QnaBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.QnaBoardVO;

public class QnaBoardService {
	
	static int view_rows = 10; 
	static int counts = 15; 
	
	QnaBoardDAO qnaBoardDAO;
	
	public void setQnaBoardDAO (QnaBoardDAO qnaBoardDAO) {
		this.qnaBoardDAO = qnaBoardDAO;		
	}
	
	public void insertQnaBoard(QnaBoardVO qnaBoardVO){		
		try {
			qnaBoardDAO.insertQnaBoard(qnaBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
