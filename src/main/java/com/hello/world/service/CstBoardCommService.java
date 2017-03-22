package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.CstBoardCommDAO;
import com.hello.world.dto.CstBoardCommVO;
import com.hello.world.dto.DogBoardCommVO;
import com.hello.world.dto.MeetBoardCommVO;


public class CstBoardCommService {
	
	@Autowired
	private CstBoardCommDAO cstBoardCommDAO;
	
	public void setCstBoardCommDAO(CstBoardCommDAO cstBoardCommDAO) {
		this.cstBoardCommDAO = cstBoardCommDAO;
	}

	public ArrayList<CstBoardCommVO> listCstBoardComm(
			String cstboard_counsel_posting_no) throws SQLException {
		ArrayList<CstBoardCommVO> cstBoardCommList = cstBoardCommDAO
				.listCstBoardComm(cstboard_counsel_posting_no);

		return cstBoardCommList;
	}
	public int insertComm(CstBoardCommVO vo) throws SQLException {
		int result = cstBoardCommDAO.insertCstBoardComm(vo);
		return result;
	}
	
	public CstBoardCommVO getCstBoardComm(String cstboard_ans_code)throws SQLException{
		return cstBoardCommDAO.getCstBoardComm(cstboard_ans_code);
	}
	
	public int getMaxSeq() throws SQLException{
		return cstBoardCommDAO.getMaxSeq();
	}
	
	
	public void deleteCstBoardComm(String cstboard_ans_code){
	try {
		cstBoardCommDAO.deleteCstBoardComm(cstboard_ans_code);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}	
}
