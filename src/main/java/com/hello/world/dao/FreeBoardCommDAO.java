package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardCommVO;

public interface FreeBoardCommDAO {  
	
	public int insertFreeBoardComm(FreeBoardCommVO freeBoardCommVO)throws SQLException;
	public ArrayList<FreeBoardCommVO> listFreeBoardComm(String freeboard_posting_no)throws SQLException;
	public void deleteFreeBoardComm(String freeBoardCommVO)throws SQLException;
	public void updateFreeBoardComm(FreeBoardCommVO freeBoardCommVO)throws SQLException;
	
}


