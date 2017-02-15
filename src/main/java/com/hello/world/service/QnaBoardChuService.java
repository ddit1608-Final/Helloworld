package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.QnaBoardChuDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.JobhtBoardVO;
import com.hello.world.dto.QnaBoardCheckChuVO;
import com.hello.world.dto.QnaBoardChuVO;
import com.hello.world.dto.QnaBoardCommVO;

public class QnaBoardChuService {
	
	@Autowired
	private QnaBoardChuDAO qnaBoardChuDAO;

	public void setQnaBoardChuDAO(QnaBoardChuDAO qnaBoardChuDAO) {
		this.qnaBoardChuDAO = qnaBoardChuDAO;
	}
	
	public void updateQnaBoardChuComm(QnaBoardChuVO qnaBoardChuVO) {
		try {
			this.qnaBoardChuDAO.updateQnaBoardChuComm(qnaBoardChuVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateQnaBoardBChuComm(QnaBoardChuVO qnaBoardChuVO) {
		try {
			this.qnaBoardChuDAO.updateQnaBoardBChuComm(qnaBoardChuVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public QnaBoardChuVO listQnaBoardChu(
			String qnaboard_ans_code) throws SQLException {
		QnaBoardChuVO qnaBoardChuVO = qnaBoardChuDAO.listQnaBoardChu(qnaboard_ans_code);

		return qnaBoardChuVO;
	}
	
	public void insertCheckChu(QnaBoardCheckChuVO qnaBoardCheckChuVO){		
		try {
			qnaBoardChuDAO.insertCheckChu(qnaBoardCheckChuVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public QnaBoardCheckChuVO CheckChu(
			String qnaboard_ans_code) throws SQLException {
		QnaBoardCheckChuVO qnaBoardCheckChuVO = qnaBoardChuDAO.CheckChu(qnaboard_ans_code);
		
		return qnaBoardCheckChuVO;
	}
	
}
