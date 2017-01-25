package com.hello.world.dao.iBatis;

import java.sql.SQLException;

import com.hello.world.dao.PointDAO;
import com.hello.world.dto.PointVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class PointDAO_ibatis implements PointDAO{
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertPoint(PointVO pointVO) throws SQLException {
		int result = -1;
		if (client.insert("insertPoint", pointVO) != null) {
			result = -1;
		} else {
			result = 1;
		}
		return result;
	}

	@Override
	public int sumPoint(String mem_mail) throws SQLException {
		int sum = 0;
		
		Object ob = client.queryForObject("sumPoint", mem_mail); 
		
		sum = (Integer)ob;
	 
				
		
		return sum;
	}

}
