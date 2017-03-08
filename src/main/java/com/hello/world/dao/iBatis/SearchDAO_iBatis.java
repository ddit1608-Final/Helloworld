package com.hello.world.dao.iBatis;

import java.sql.SQLException;

import com.hello.world.dao.SearchDAO;
import com.hello.world.dto.SearchVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class SearchDAO_iBatis implements SearchDAO {
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int getTotal(SearchVO searchVO) throws SQLException {
		
		int list = (int) client.queryForObject("getTotal", searchVO);
		
		return list;
	}

}
