package com.hello.world.dao.iBatis;

import java.sql.SQLException;

import com.hello.world.dao.QnaboardBChuDAO;
import com.hello.world.dto.QnaBoardBChuVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaBoardBChuDAO_iBatis implements QnaboardBChuDAO {
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public void updateQnaBoardChuComm(QnaBoardBChuVO qnaBoardBChuVO)
			throws SQLException {
		client.update("updateqnaBoardBChu", qnaBoardBChuVO);
	}

	@Override
	public void updateQnaBoardBChuComm(QnaBoardBChuVO qnaBoardBChuVO)
			throws SQLException {
		client.update("updateqnaBoardBBchu", qnaBoardBChuVO);
	}

	@Override
	public QnaBoardBChuVO listQnaBoardBChu(String qnaboard_posting_no)
			throws SQLException {
		
		QnaBoardBChuVO qnaBoardBChuVO = (QnaBoardBChuVO) client
				.queryForObject("listQnaBoardBChu", qnaboard_posting_no);
		
		return qnaBoardBChuVO;
	}

}
