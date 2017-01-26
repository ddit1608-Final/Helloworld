package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.JobhtBoardVO;

public interface JobhtBoardDAO {
	public void insertJobthBoard(JobhtBoardVO jobhtBoardVO)throws SQLException;
	public ArrayList<JobhtBoardVO> listAllJobhtBoard(int startRow, String jobhtboard_title, int counts)throws SQLException;
	public int totalRecord(String name)throws SQLException;

}
