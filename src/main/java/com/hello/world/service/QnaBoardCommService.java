package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.QnaBoardCommDAO;
import com.hello.world.dto.QnaBoardCommVO;

public class QnaBoardCommService {
	
	@Autowired
	private QnaBoardCommDAO qnaBoardCommDAO;

	public void setQnaBoardCommDAO(QnaBoardCommDAO qnaBoardCommDAO) {
		this.qnaBoardCommDAO = qnaBoardCommDAO;
	}
	
	public int insertComm(QnaBoardCommVO vo) throws SQLException {
		int result = qnaBoardCommDAO.insertQnaBoardComm(vo);

		return result;
	}
	public ArrayList<QnaBoardCommVO> listQnaBoardComm(
			String qnaboard_posting_no) throws SQLException {
		ArrayList<QnaBoardCommVO> qnaBoardCommList = qnaBoardCommDAO
				.listQnaBoardComm(qnaboard_posting_no);

		return qnaBoardCommList;
	}
	public void deleteFreeBoardComm(String qnaboard_ans_code){
		
		try {
			qnaBoardCommDAO.deleteQnaBoardComm(qnaboard_ans_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void updateFreeBoardComm(QnaBoardCommVO qnaBoardCommVO){		
		try {
			qnaBoardCommDAO.updateQnaBoardComm(qnaBoardCommVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
