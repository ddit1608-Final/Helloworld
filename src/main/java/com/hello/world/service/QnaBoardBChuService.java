package com.hello.world.service;

import java.sql.SQLException;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.QnaboardBChuDAO;
import com.hello.world.dto.QnaBoardBChuVO;

public class QnaBoardBChuService {
	
	@Autowired
	private QnaboardBChuDAO qnaboardBChuDAO;

	public void setQnaboardBChuDAO(QnaboardBChuDAO qnaboardBChuDAO) {
		this.qnaboardBChuDAO = qnaboardBChuDAO;
	}
	
	public void updateQnaBoardBChu(QnaBoardBChuVO qnaBoardBChuVO) {
		try {
			this.qnaboardBChuDAO.updateQnaBoardChuComm(qnaBoardBChuVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateQnaBoardBBChu(QnaBoardBChuVO qnaBoardBChuVO) {
		try {
			this.qnaboardBChuDAO.updateQnaBoardBChuComm(qnaBoardBChuVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public QnaBoardBChuVO listQnaBoardBChu(String qnaboard_posting_no) throws SQLException {

		QnaBoardBChuVO qnaBoardBChuVO = qnaboardBChuDAO.listQnaBoardBChu(qnaboard_posting_no);

		return qnaBoardBChuVO;
	}
	
	public ArrayList<QnaBoardBChuVO> listAllQnaBoardBChu() throws SQLException {

		ArrayList<QnaBoardBChuVO> qnaBoardBChuList = null;
		qnaBoardBChuList = qnaboardBChuDAO.listAllQnaBChuBoard();

		return qnaBoardBChuList;
	}

}
