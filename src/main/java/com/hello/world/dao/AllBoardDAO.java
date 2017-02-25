package com.hello.world.dao;

import java.sql.SQLException;
import java.util.List;

import com.hello.world.dto.AllBoardVO;
import com.hello.world.dto.testVO;

public interface AllBoardDAO {

	public List<AllBoardVO> getAllBoardList(int startRow,testVO testVO,int counts)throws SQLException;
	
	public int totalRecord(testVO testVO) throws SQLException;
	
	public int getTotal(testVO testVO)throws SQLException;
}
