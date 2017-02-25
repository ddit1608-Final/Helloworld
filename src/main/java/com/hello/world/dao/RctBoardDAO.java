package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.RctBoardVO;
import com.hello.world.dto.rctSearchVO;
import com.hello.world.dto.testVO;


public interface RctBoardDAO {
	
	public void insertRctBoard(RctBoardVO rctBoardVO)throws SQLException;
	public ArrayList<RctBoardVO> listAllRctBoard(int startRow, rctSearchVO rctSearchVO, int counts)throws SQLException;
//	public ArrayList<RctBoardVO> listAllRctBoard(int startRow, testVO testVO, int counts)throws SQLException;
	public ArrayList<RctBoardVO> getRctBoardList(int startRow, rctSearchVO rctSearchVO,int counts)throws SQLException;
//	public ArrayList<RctBoardVO> getRctBoardList(int startRow, testVO testVO,int counts)throws SQLException;
	public int getTotal(rctSearchVO rctSearchVO)throws SQLException;
//	public int getTotal(testVO testVO)throws SQLException;
//	public int totalRecord(testVO testVO)throws SQLException;
	public int totalRecord(rctSearchVO rctSearchVO) throws SQLException;
	public RctBoardVO getRctDetail(String rctboard_posting_no)throws SQLException;
}
