package com.hello.world.dao.iBatis;

import java.sql.SQLException;

import java.util.ArrayList;

import com.hello.world.dao.PostingDAO;
import com.hello.world.dto.PostingTypeVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class PostingDAO_iBatis implements PostingDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<PostingTypeVO> listPostingVO() throws SQLException {
		ArrayList<PostingTypeVO> postingList = 
				(ArrayList<PostingTypeVO>) client.queryForList("listPosting", null);
		return postingList;
	}

}
