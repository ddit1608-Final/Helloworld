package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;

@Service
public class MemberService {
	@Autowired
	private FreeBoardDAO freeBoardDAO;

	@Autowired
	private MemberDAO_iBatis memDao;

	public void setMemDao(MemberDAO_iBatis memDao) {
		this.memDao = memDao;
	}

	public int joinMember(MemVO memVO) throws SQLException {
		int result = memDao.insertMember(memVO);

		return result;
	}

	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}
	
	public ArrayList<MemVO> getMemberList(String key){
		ArrayList<MemVO> memberList=null;
		try {
			memberList = memDao.listMember(key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	public MemVO getMember(String id){
		MemVO member=null;
		try {
			member=memDao.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
		
	/*public ArrayList<FreeBoardVO> getFreeBoardList(String loginID){
		ArrayList<FreeBoardVO> freeBoardList=null;
		try {
			freeBoardList = freeBoardDAO.listFreeBoard(loginID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardList;
	}
	
	public FreeBoardVO getFreeBoardVO(String freeboard_posting_no){
		FreeBoardVO freeBoardVO = null;
		try {
			freeBoardVO = freeBoardDAO.getFreeBoard(freeboard_posting_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardVO;
	}
	
	public void insertFreeBoard(FreeBoardVO freeBoardVO){		
		try {
			freeBoardDAO.insertFreeBoard(freeBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

	public int confirmID(String userid) throws SQLException {
		int result = -1;

		result = memDao.confirmID(userid);

		return result;
	}
}
