package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.FreeBoardCommDAO;
import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.IsBoardCommVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FreeBoardCommDAO_iBatis implements FreeBoardCommDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertFreeBoardComm(FreeBoardCommVO freeBoardCommVO)
			throws SQLException {
		int result = -1;
		// 성공시..
		if (client.insert("insertFreeBoardComm", freeBoardCommVO) == null)
			result = 1;

		return result;

	}

	@Override
	public ArrayList<FreeBoardCommVO> listFreeBoardComm(
			String freeboard_posting_no) throws SQLException {
		ArrayList<FreeBoardCommVO> freeBoardCommList = (ArrayList<FreeBoardCommVO>) client
				.queryForList("listFreeBoardComm", freeboard_posting_no);
		
		return freeBoardCommList;
	}

	@Override
	public void deleteFreeBoardComm(String freeboard_ans_code) throws SQLException {
		client.delete("deleteFreeBoardComm",freeboard_ans_code);
		
	}

	@Override
	public void updateFreeBoardComm(FreeBoardCommVO freeBoardCommVO)
			throws SQLException {
		client.update("updateFreeBoardComm",freeBoardCommVO);
	}
	@Override
	public int getMaxSeq() throws SQLException {
		
		return (int) client.queryForObject("getFreeMaxAnxCode");
	}

	@Override
	public FreeBoardCommVO getFreeBoardComm(String freeboard_ans_code)
			throws SQLException {
		return (FreeBoardCommVO) client.queryForObject("getFreeBoardComm",freeboard_ans_code);
	}

}
