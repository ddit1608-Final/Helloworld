package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dto.FreeBoardVO;

public class FreeBoardService {

	
	FreeBoardDAO freeBoardDAO;
	
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO){
		this.freeBoardDAO=freeBoardDAO;
	}
	

	public ArrayList<FreeBoardVO> listAllFreeBoard() throws SQLException{
		ArrayList<FreeBoardVO> list = freeBoardDAO.listAllFreeBoard();
		return list;
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
	}
	public FreeBoardVO getFreeDetail(String freeboard_posting_no){
		FreeBoardVO freeBoardVO = null;
		
		try {
			freeBoardVO = freeBoardDAO.getFreeDetail(freeboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return freeBoardVO;
	}
	public void updateFreeBoard(FreeBoardVO freeBoardVO){		
		try {
			freeBoardDAO.updateFreeBoard(freeBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFreeBoard(String freeboard_posting_no){
		
		try {
			freeBoardDAO.deleteFreeBoard(freeboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}











