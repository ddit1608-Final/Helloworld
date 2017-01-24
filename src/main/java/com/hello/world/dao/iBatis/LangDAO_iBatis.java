package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.LangDAO;
import com.hello.world.dto.LangVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class LangDAO_iBatis implements LangDAO{
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<LangVO> listLangVO() throws SQLException {
		ArrayList<LangVO> langList = (ArrayList<LangVO>) client.queryForList(
				"listLang", null);
		return langList;
	}

}
