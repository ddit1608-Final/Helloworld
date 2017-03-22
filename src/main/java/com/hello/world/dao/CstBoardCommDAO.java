package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.CstBoardCommVO;
import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.MeetBoardCommVO;

public interface CstBoardCommDAO {
	
	public ArrayList<CstBoardCommVO> listCstBoardComm(String cstboard_counsel_posting_no)throws SQLException;
	public int insertCstBoardComm(CstBoardCommVO cstBoardCommVO)throws SQLException;
	public CstBoardCommVO getCstBoardComm(String cstboard_ans_code) throws SQLException;
	public int getMaxSeq() throws SQLException;
	public void deleteCstBoardComm(String CstBoardCommVO)throws SQLException;
	//public void updateFreeBoardComm(FreeBoardCommVO freeBoardCommVO)throws SQLException; 
}
