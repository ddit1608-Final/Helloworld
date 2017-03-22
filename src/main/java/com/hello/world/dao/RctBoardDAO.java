package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.RctBoardVO;
import com.hello.world.dto.SearchVO;


public interface RctBoardDAO {
	
	public void insertRctBoard(RctBoardVO rctBoardVO)throws SQLException;
	public ArrayList<RctBoardVO> listAllRctBoard(int startRow, SearchVO searchVO, int counts)throws SQLException;
	public ArrayList<RctBoardVO> getRctBoardList(int startRow, SearchVO searchVO,int counts)throws SQLException;
	public int getTotal(SearchVO searchVO)throws SQLException;
	public int totalRecord(SearchVO searchVO) throws SQLException;
	public RctBoardVO getRctDetail(String rctboard_posting_no)throws SQLException;
	public void deleteRctBoard(String rctboard_posting_no)throws SQLException;
}

