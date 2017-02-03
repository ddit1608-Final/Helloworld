package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.IsBoardCommDAO;
import com.hello.world.dto.IsBoardCommVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class IsBoardCommDAO_iBatis implements IsBoardCommDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertIsBoardComm(IsBoardCommVO isBoardCommVO)
			throws SQLException {
		int result = -1;
		if(client.insert("insertIsBoardComm",isBoardCommVO)==null)
			result=1;
		
		return result;
	}

	@Override
	public ArrayList<IsBoardCommVO> listIsBoardComm(
			String ifshrboard_posting_no) throws SQLException {
		ArrayList<IsBoardCommVO> isBoardCommList = (ArrayList<IsBoardCommVO>)
				client.queryForList("listIsBoardComm",ifshrboard_posting_no);
		
		return isBoardCommList;
	}

	@Override
	public void deleteIsBoardComm(String ifshrboard_ans_code) throws SQLException {
		client.delete("deleteIsBoardComm", ifshrboard_ans_code);
	}

	@Override
	public void updateIsBoardComm(IsBoardCommVO isBoardCommVO)
			throws SQLException {
		client.update("updateIsBoardComm", isBoardCommVO);
	}

	@Override
	public IsBoardCommVO getIsBoardComm(String ifshrboard_ans_code)
			throws SQLException {
		return (IsBoardCommVO) client.queryForObject("getIsBoardComm",ifshrboard_ans_code);
	}

	
}