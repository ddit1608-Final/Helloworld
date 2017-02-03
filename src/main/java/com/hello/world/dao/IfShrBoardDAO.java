package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;


public interface IfShrBoardDAO {  
	
	
	public ArrayList<IfShrBoardVO> listAllIfShrBoard(int startRow, String ifshrboard_title, int counts)throws SQLException;
	public int totalRecord(String name) throws SQLException;
	
	public int insertIfShrBoard(IfShrBoardVO ifShrBoardVO)throws SQLException;
	
	public IfShrBoardVO getIfShrBoardDetail(String ifshrboard_posting_no)throws SQLException;
	
	public void updateIfShrBoard(IfShrBoardVO ifShrBoardVO)throws SQLException;
	
	public void deleteIfShrBoard(String ifShrBoardVO)throws SQLException;
}


