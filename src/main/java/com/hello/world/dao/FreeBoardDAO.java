package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardVO;


public interface FreeBoardDAO {  
	
	public ArrayList<FreeBoardVO> listFreeBoard(String mem_mail) throws SQLException;
	public FreeBoardVO getFreeDetail(String freeboard_posting_no )throws SQLException;
	public FreeBoardVO getFreeBoard(String freeboard_posting_no) throws SQLException;
	public void insertFreeBoard(FreeBoardVO freeBoardVO)throws SQLException;
	public ArrayList<FreeBoardVO> listAllFreeBoard(int startRow, String freeboard_title, int counts)throws SQLException;
	public void updateFreeBoard(FreeBoardVO freeBoardVO)throws SQLException;
	public void deleteFreeBoard(String freeBoardVO)throws SQLException;
	public int totalRecord(String name)throws SQLException;
}


