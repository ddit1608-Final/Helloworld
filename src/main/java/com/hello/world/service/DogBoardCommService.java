package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.DogBoardCommDAO;
import com.hello.world.dto.DogBoardCommVO;

@Service
public class DogBoardCommService {
	
	@Autowired
	private DogBoardCommDAO dogBoardCommDAO;

	public void setDogBoardCommDAO(DogBoardCommDAO dogBoardCommDAO) {
		this.dogBoardCommDAO = dogBoardCommDAO;
	}

	public int insertComm(DogBoardCommVO vo) throws SQLException {
		int result = dogBoardCommDAO.insertDsBoardComm(vo);

		return result;
	}

	public ArrayList<DogBoardCommVO> listDsBoardComm(
			String dsboard_posting_no) throws SQLException {
		ArrayList<DogBoardCommVO> dsBoardCommList = dogBoardCommDAO
				.listDsBoardComm(dsboard_posting_no);

		return dsBoardCommList;
	}
	public void deleteDsBoardComm(String dsboard_ans_code){
		
		try {
			dogBoardCommDAO.deleteDsBoardComm(dsboard_ans_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void updateDsBoardComm(DogBoardCommVO dogBoardCommVO){		
		try {
			dogBoardCommDAO.updateDsBoardComm(dogBoardCommVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public DogBoardCommVO getDsBoardComm(String dsboard_ans_code)
			throws SQLException {
		
		return dogBoardCommDAO.getDsBoardComm(dsboard_ans_code);
	}
	
	public int getMaxSeq() throws SQLException {
		
		return dogBoardCommDAO.getMaxSeq();
	}

}
