package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.DogBoardCommVO;
import com.hello.world.dto.IsBoardCommVO;


public interface DogBoardCommDAO {  
	
	public int insertDsBoardComm(DogBoardCommVO dogBoardCommVO)throws SQLException;
	public ArrayList<DogBoardCommVO> listDsBoardComm(String dsboard_posting_no)throws SQLException;
	public void deleteDsBoardComm(String dogBoardCommVO)throws SQLException;
	public void updateDsBoardComm(DogBoardCommVO dogBoardCommVO)throws SQLException;
	public DogBoardCommVO getDsBoardComm (String dsboard_ans_code)throws SQLException;
	public int getMaxSeq() throws SQLException;
}


