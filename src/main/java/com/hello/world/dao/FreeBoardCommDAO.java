package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;


public interface FreeBoardCommDAO {  
	
	public int insertFreeBoardComm(FreeBoardCommVO freeBoardCommVO)throws SQLException;
	public ArrayList<FreeBoardCommVO> listFreeBoardComm(String freeboard_posting_no)throws SQLException;
}


