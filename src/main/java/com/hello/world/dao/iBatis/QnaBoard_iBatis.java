package com.hello.world.dao.iBatis;

import java.sql.SQLException;

import com.hello.world.dao.QnaBoardDAO;
import com.hello.world.dto.QnaBoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaBoard_iBatis implements QnaBoardDAO {
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public void insertQnaBoard(QnaBoardVO qnaBoardVO) throws SQLException {
		
		client.insert("insertQnaBoard", qnaBoardVO);
		
	}

}
