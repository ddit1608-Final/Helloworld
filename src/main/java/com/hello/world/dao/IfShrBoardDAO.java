package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.IfShrBoardVO;


public interface IfShrBoardDAO {  
	
	
	public ArrayList<IfShrBoardVO> listAllIfShrBoard(int startRow, String ifshrboard_title, int counts)throws SQLException;
	public int totalRecord(String name) throws SQLException;
}

