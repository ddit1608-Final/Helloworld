package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.IsBoardCommVO;

public interface FreeBoardCommDAO {  
	
	public int insertFreeBoardComm(FreeBoardCommVO freeBoardCommVO)throws SQLException;
	public ArrayList<FreeBoardCommVO> listFreeBoardComm(String freeboard_posting_no)throws SQLException;
	public void deleteFreeBoardComm(String freeBoardCommVO)throws SQLException;
	public void updateFreeBoardComm(FreeBoardCommVO freeBoardCommVO)throws SQLException;
	public FreeBoardCommVO getFreeBoardComm (String freeboard_ans_code)throws SQLException;
	public int getMaxSeq() throws SQLException;
	
}


