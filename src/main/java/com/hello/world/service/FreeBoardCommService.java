package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.FreeBoardCommDAO;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.FreeBoardCommVO;

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

}
