package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.IsBoardCommDAO;
import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.IsBoardCommVO;

@Service
public class IsBoardCommService {
	
	@Autowired
	private IsBoardCommDAO isBoardCommDAO;

	public void setIsBoardCommDAO(IsBoardCommDAO isBoardCommDAO) {
		this.isBoardCommDAO = isBoardCommDAO;
	}

	public int insertComm(IsBoardCommVO vo) throws SQLException {
		int result = isBoardCommDAO.insertIsBoardComm(vo);

		return result;
	}

	public ArrayList<IsBoardCommVO> listIsBoardComm(
			String ifshrboard_posting_no) throws SQLException {
		ArrayList<IsBoardCommVO> isBoardCommList = isBoardCommDAO
				.listIsBoardComm(ifshrboard_posting_no);

		return isBoardCommList;
	}
	/*public void deleteFreeBoardComm(String freeboard_ans_code){
		
		try {
			freeBoardCommDAO.deleteFreeBoardComm(freeboard_ans_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void updateFreeBoardComm(FreeBoardCommVO freeBoardCommVO){		
		try {
			freeBoardCommDAO.updateFreeBoardComm(freeBoardCommVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
}
