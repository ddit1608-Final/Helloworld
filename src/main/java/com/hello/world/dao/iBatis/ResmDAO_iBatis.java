package com.hello.world.dao.iBatis;

import java.sql.SQLException;

import com.hello.world.dao.ResmDAO;
import com.hello.world.dto.ResmVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ResmDAO_iBatis implements ResmDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public void insertResm(ResmVO resmVO) throws SQLException {		
		client.insert("insertResm", resmVO);
	}
}
