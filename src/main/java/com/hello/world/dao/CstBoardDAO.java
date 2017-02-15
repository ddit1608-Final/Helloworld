package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.CstBoardCounselVO;
import com.hello.world.dto.FreeBoardVO;

public interface CstBoardDAO {

	public ArrayList<CstBoardCounselVO> listCstBoard(String mem_mail, int startRow, int counts)
			throws SQLException;
	
	public ArrayList<CstBoardCounselVO> listCstBoardAdmin(int startRow, int counts)
			throws SQLException;

	public int insertCstBoard(CstBoardCounselVO cstBoardCounselVO)
			throws SQLException;

	public int totalCstBoard(String mem_mail) throws SQLException;
	
	public int totalCstBoardAdmin() throws SQLException;

	public CstBoardCounselVO getCstBoard(String cstboard_counsel_posting_no)
			throws SQLException;
	public void updateCstBoard(CstBoardCounselVO cstBoardCounselVO)throws SQLException;
}
