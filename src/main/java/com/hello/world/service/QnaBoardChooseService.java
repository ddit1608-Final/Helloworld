package com.hello.world.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.QnaBoardChooseDAO;
import com.hello.world.dto.QnaBoardChooseVO;

public class QnaBoardChooseService {
	
	@Autowired
	private QnaBoardChooseDAO qnaBoardChooseDAO;	
	
	public void setQnaBoardChooseDAO(QnaBoardChooseDAO qnaBoardChooseDAO) {
		this.qnaBoardChooseDAO = qnaBoardChooseDAO;
	}



	public int insertQnaBoardChoose(QnaBoardChooseVO vo) throws SQLException {
		int result =  qnaBoardChooseDAO.insertQnaBoardChoose(vo);

		return result;
	}

	
}
