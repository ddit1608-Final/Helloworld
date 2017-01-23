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
	
	public ArrayList<FreeBoardVO> getFreeBoardList(){

		ArrayList<FreeBoardVO> freeBoardList = null;
		try {
			freeBoardList = freeBoardDAO.listAllFreeBoard();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardList;
	}
	
	public FreeBoardVO getFreeBoardDetail(String qseq){
		FreeBoardVO freeBoardVO = null;
		try {
			freeBoardVO = freeBoardDAO.getFreeBoard(Integer.parseInt(qseq));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardVO;
	}
	
	public void updateFreeBoardVO(FreeBoardVO freeBoardVO){
		try {
			freeBoardDAO.updateFreeBoard(freeBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}











