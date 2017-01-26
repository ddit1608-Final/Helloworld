package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.CrrDAO;
import com.hello.world.dto.CrrVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CrrDAO_iBatis implements CrrDAO{
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<CrrVO> listCrrVO() throws SQLException {
		ArrayList<CrrVO> crrList = (ArrayList<CrrVO>) client.queryForList(
				"listCrr", null);
		return crrList;
	}

}
