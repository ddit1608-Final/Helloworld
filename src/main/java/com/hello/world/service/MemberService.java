package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemberVO;



public class MemberService {
	
	private FreeBoardDAO freeBoardDAO;
	private MemberDAO memberDAO;
	
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO){
		this.freeBoardDAO=freeBoardDAO;
	}
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO=memberDAO;
	}
	
	public ArrayList<MemberVO> getMemberList(String key){
		ArrayList<MemberVO> memberList=null;
		try {
			memberList = memberDAO.listMember(key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	public MemberVO getMember(String id){
		MemberVO member=null;
		try {
			member=memberDAO.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
		
	public ArrayList<FreeBoardVO> getFreeBoardList(String loginID){
		ArrayList<FreeBoardVO> freeBoardList=null;
		try {
			freeBoardList = freeBoardDAO.listFreeBoard(loginID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardList;
	}
	
	public FreeBoardVO getFreeBoardVO(int qseq){
		FreeBoardVO freeBoardVO = null;
		try {
			freeBoardVO = freeBoardDAO.getFreeBoard(qseq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardVO;
	}
	
	public void insertFreeBoard(FreeBoardVO freeBoardVO,String id){		
		try {
			freeBoardDAO.insertFreeBoard(freeBoardVO, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}







