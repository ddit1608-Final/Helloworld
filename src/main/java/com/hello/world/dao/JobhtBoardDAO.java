package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.JobhtBoardVO;
import com.hello.world.dto.testVO;

public interface JobhtBoardDAO {
	public void insertJobthBoard(JobhtBoardVO jobhtBoardVO)throws SQLException;
	public ArrayList<JobhtBoardVO> listAllJobhtBoard(int startRow, testVO testVO, int counts)throws SQLException;
	public int totalRecord(testVO testVO)throws SQLException;

}
