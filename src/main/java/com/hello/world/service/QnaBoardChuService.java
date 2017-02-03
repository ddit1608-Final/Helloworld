package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.QnaBoardChuDAO;
import com.hello.world.dto.FreeBoardVO;
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
	
	public QnaBoardChuVO listQnaBoardChu(
			String qnaboard_ans_code) throws SQLException {
		QnaBoardChuVO qnaBoardChuVO = qnaBoardChuDAO.listQnaBoardChu(qnaboard_ans_code);

		return qnaBoardChuVO;
	}

}
