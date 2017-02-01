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
	public int insertQnaBoardChu(QnaBoardChuVO qnaBoardChuVO)
			throws SQLException {
		
		int result = -1;
		
		if(client.insert("insertQnaBoardChu", qnaBoardChuVO) == null)
			
		result = 1;
		
		return result;
	}

}
