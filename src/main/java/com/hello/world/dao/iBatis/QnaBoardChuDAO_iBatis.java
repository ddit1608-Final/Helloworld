package com.hello.world.dao.iBatis;

import java.sql.SQLException;

import com.hello.world.dao.QnaBoardChuDAO;
import com.hello.world.dto.QnaBoardChuVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaBoardChuDAO_iBatis implements QnaBoardChuDAO {
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public void updateQnaBoardChuComm(QnaBoardChuVO qnaBoardChuVO)
			throws SQLException {

		client.update("updateQnaBoardChuComm", qnaBoardChuVO);
		
	}
	
	

}
