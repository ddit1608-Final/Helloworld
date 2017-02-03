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
	public void deleteIsBoardComm(String ifshrboard_ans_code){
		
		try {
			isBoardCommDAO.deleteIsBoardComm(ifshrboard_ans_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void updateIsBoardComm(IsBoardCommVO isBoardCommVO){		
		try {
			isBoardCommDAO.updateIsBoardComm(isBoardCommVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public IsBoardCommVO getIsBoardComm(String ifshrboard_ans_code)
			throws SQLException {
		
		return isBoardCommDAO.getIsBoardComm(ifshrboard_ans_code);
	}

}
