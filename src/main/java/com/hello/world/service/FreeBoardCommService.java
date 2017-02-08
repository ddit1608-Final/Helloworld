package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.FreeBoardCommDAO;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;

@Service
public class FreeBoardCommService {
	@Autowired
	private FreeBoardCommDAO freeBoardCommDAO;

	public void setFreeBoardCommDAO(FreeBoardCommDAO freeBoardCommDAO) {
		this.freeBoardCommDAO = freeBoardCommDAO;
	}

	public int insertComm(FreeBoardCommVO vo) throws SQLException {
		int result = freeBoardCommDAO.insertFreeBoardComm(vo);

		return result;
	}

	public ArrayList<FreeBoardCommVO> listFreeBoardComm(
			String freeboard_posting_no) throws SQLException {
		ArrayList<FreeBoardCommVO> freeBoardCommList = freeBoardCommDAO
				.listFreeBoardComm(freeboard_posting_no);

		return freeBoardCommList;
	}
	public void deleteFreeBoardComm(String freeboard_ans_code){
		
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
	}
	public FreeBoardCommVO getFreeBoardComm(String freeboard_ans_code)
			throws SQLException {
		return freeBoardCommDAO.getFreeBoardComm(freeboard_ans_code);
	}
	public int getMaxSeq() throws SQLException {
		
		return freeBoardCommDAO.getMaxSeq();
	}
}
