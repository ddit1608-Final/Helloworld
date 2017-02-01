package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.FlowDAO;
import com.hello.world.dto.FlowVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FlowDAO_iBatis implements FlowDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<FlowVO> listFlowVO() throws SQLException {
		ArrayList<FlowVO> langList = (ArrayList<FlowVO>) client.queryForList(
				"listFlow", null);
		return langList;
	}

}
