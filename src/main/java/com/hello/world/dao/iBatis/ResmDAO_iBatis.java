package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

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
	@Override
	public ArrayList<ResmVO> listResm(String mem_mail) throws SQLException {
		ArrayList<ResmVO> resmList = new ArrayList<ResmVO>();
		resmList = (ArrayList<ResmVO>)client.queryForList("listResm",mem_mail);
		return resmList;
	}
	

}
