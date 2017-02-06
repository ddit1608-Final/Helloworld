package com.hello.world.dao.iBatis;

import java.sql.SQLException;

import com.hello.world.dao.QnaBoardChooseDAO;
import com.hello.world.dto.QnaBoardChooseVO;
import com.hello.world.dto.QnaBoardChuVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaBoardChooseDAO_iBatis implements QnaBoardChooseDAO {
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertQnaBoardChoose(QnaBoardChooseVO qnaBoardChooseVO)
			throws SQLException {
		
		int result = -1;

		if (client.insert("insertQnaBoardChoose", qnaBoardChooseVO) == null)
			result = 1;

		return result;
	}

	@Override
	public QnaBoardChooseVO listQnaBoardChoose(String qnaboard_ans_code)
			throws SQLException {
		QnaBoardChooseVO qnaBoardChooseVO = (QnaBoardChooseVO) client
				.queryForObject("listQnaBoardChoose", qnaboard_ans_code);
		
		return qnaBoardChooseVO;
	}

}
