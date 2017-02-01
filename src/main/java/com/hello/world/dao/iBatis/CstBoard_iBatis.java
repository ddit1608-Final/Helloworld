package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.CstBoardDAO;
import com.hello.world.dto.CstBoardCounselVO;
import com.hello.world.dto.FreeBoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CstBoard_iBatis implements CstBoardDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<CstBoardCounselVO> listCstBoard(String mem_mail)
			throws SQLException {
		ArrayList<CstBoardCounselVO> cstBoardList = new ArrayList<CstBoardCounselVO>();
		cstBoardList = (ArrayList<CstBoardCounselVO>) client.queryForList(
				"selectCstBoard", mem_mail);
		return cstBoardList;
	}

	@Override
	public int insertCstBoard(CstBoardCounselVO cstBoardCounselVO)
			throws SQLException {
		int result = -1;
		if (client.insert("insertCstBoard", cstBoardCounselVO) == null)
			result = 1;
		return result;
	}

	@Override
	public int totalCstBoard(String mem_mail) throws SQLException {
		int total_pages = 0;
		
		total_pages = (Integer) client.queryForObject("totalCstBoard",
				mem_mail);
		return total_pages;
	}

	@Override
	public CstBoardCounselVO getCstBoard(String cstboard_counsel_posting_no)
			throws SQLException {
		CstBoardCounselVO cstBoardVo = (CstBoardCounselVO) client.queryForObject(
				"getCstBoard", cstboard_counsel_posting_no);
		return cstBoardVo;
	}

	@Override
	public void updateCstBoard(CstBoardCounselVO cstBoardCounselVO)
			throws SQLException {
		client.update("updateCstBoard", cstBoardCounselVO);
		
	}

}
