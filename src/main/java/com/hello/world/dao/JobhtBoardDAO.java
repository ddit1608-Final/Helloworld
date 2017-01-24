package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.JobhtBoardVO;

public interface JobhtBoardDAO {
	
	public ArrayList<JobhtBoardVO> listJobhtBoard(String jobthboard_posting_no) throws SQLException;

}
