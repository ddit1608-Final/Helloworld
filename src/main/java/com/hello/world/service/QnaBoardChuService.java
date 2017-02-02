package com.hello.world.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.QnaBoardChuDAO;
import com.hello.world.dto.QnaBoardChuVO;

public class QnaBoardChuService {
	
	@Autowired
	private QnaBoardChuDAO qnaBoardChuDAO;

	public void setQnaBoardChuDAO(QnaBoardChuDAO qnaBoardChuDAO) {
		this.qnaBoardChuDAO = qnaBoardChuDAO;
	}
	
	public int insertChu(QnaBoardChuVO vo) throws SQLException {
		
		int result = qnaBoardChuDAO.insertQnaBoardChu(vo);
		
		return result;
	}

}
