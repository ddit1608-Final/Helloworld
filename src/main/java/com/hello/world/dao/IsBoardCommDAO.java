package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.IsBoardCommVO;


public interface IsBoardCommDAO {  
	
	public int insertIsBoardComm(IsBoardCommVO isBoardCommVO)throws SQLException;
	public ArrayList<IsBoardCommVO> listIsBoardComm(String ifshrboard_posting_no)throws SQLException;
	public void deleteIsBoardComm(String isBoardCommVO)throws SQLException;
	public void updateIsBoardComm(FreeBoardCommVO isBoardCommVO)throws SQLException;
}


