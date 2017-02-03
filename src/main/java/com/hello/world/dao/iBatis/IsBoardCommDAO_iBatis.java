package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.IsBoardCommDAO;
import com.hello.world.dto.FreeBoardCommVO;
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
	public void deleteIsBoardComm(String isBoardCommVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIsBoardComm(FreeBoardCommVO isBoardCommVO)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}