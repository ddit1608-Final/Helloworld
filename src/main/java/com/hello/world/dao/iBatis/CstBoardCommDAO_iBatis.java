package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.CstBoardCommDAO;
import com.hello.world.dto.CstBoardCommVO;
import com.hello.world.dto.DogBoardCommVO;
import com.hello.world.dto.MeetBoardCommVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CstBoardCommDAO_iBatis implements CstBoardCommDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<CstBoardCommVO> listCstBoardComm(
			String cstboard_counsel_posting_no) throws SQLException {
		ArrayList<CstBoardCommVO> cstBoardCommList = (ArrayList<CstBoardCommVO>)
				client.queryForList("listCstBoardComm",cstboard_counsel_posting_no);
		
		return cstBoardCommList;
	}

	@Override
	public int insertCstBoardComm(CstBoardCommVO cstBoardCommVO)
			throws SQLException {
		int result = -1;
		// 성공시..
		if (client.insert("insertCstBoardComm", cstBoardCommVO) == null)
			result = 1;

		return result;
	}
	
	@Override
	public CstBoardCommVO getCstBoardComm(String cstboard_ans_code)
			throws SQLException {
		return (CstBoardCommVO) client.queryForObject("getCstBoardComm",cstboard_ans_code);
	}

	@Override
	public int getMaxSeq() throws SQLException {
		return (int) client.queryForObject("getCstMaxAnxCode");
	}

	@Override
	public void deleteCstBoardComm(String cstboard_ans_code) throws SQLException {
		client.delete("deleteCstBoardComm",cstboard_ans_code);
	}
}

	