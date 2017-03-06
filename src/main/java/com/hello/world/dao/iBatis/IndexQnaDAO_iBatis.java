package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.IndexQnaDAO;
import com.hello.world.dto.IndexQnaVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class IndexQnaDAO_iBatis implements IndexQnaDAO {
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<IndexQnaVO> IndexQna()
			throws SQLException {
		ArrayList<IndexQnaVO> list = new ArrayList<IndexQnaVO>();
		
		list = (ArrayList<IndexQnaVO>) client.queryForList("indexQna", list);
		
		return list;
	}

}
