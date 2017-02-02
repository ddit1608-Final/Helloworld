package com.hello.world.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.QnaBoardChuDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.QnaBoardChuVO;

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

}
