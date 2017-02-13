package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.DogBoardCommDAO;
import com.hello.world.dto.DogBoardCommVO;
import com.hello.world.dto.IsBoardCommVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class DogBoardCommDAO_iBatis implements DogBoardCommDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertDsBoardComm(DogBoardCommVO dogBoardCommVO)
			throws SQLException {
		int result = -1;
		if(client.insert("insertDsBoardComm",dogBoardCommVO)==null)
			result=1;
		
		return result;
	}

	@Override
	public ArrayList<DogBoardCommVO> listDsBoardComm(String dsboard_posting_no)
			throws SQLException {
		ArrayList<DogBoardCommVO> dsBoardCommList = (ArrayList<DogBoardCommVO>)
				client.queryForList("listDsBoardComm",dsboard_posting_no);
		
		return dsBoardCommList;
	}

	@Override
	public void deleteDsBoardComm(String dsboard_ans_code) throws SQLException {
		client.delete("deleteDsBoardComm", dsboard_ans_code);
		
	}

	@Override
	public void updateDsBoardComm(DogBoardCommVO dogBoardCommVO)
			throws SQLException {
		client.update("updateDsBoardComm", dogBoardCommVO);
		
	}

	@Override
	public DogBoardCommVO getDsBoardComm(String dsboard_ans_code)
			throws SQLException {
		return (DogBoardCommVO) client.queryForObject("getDsBoardComm",dsboard_ans_code);
	}

	@Override
	public int getMaxSeq() throws SQLException {
		return (int) client.queryForObject("getDsMaxAnxCode");
	}

	
}