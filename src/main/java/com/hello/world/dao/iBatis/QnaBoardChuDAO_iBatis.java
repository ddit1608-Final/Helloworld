package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.QnaBoardChuDAO;
import com.hello.world.dto.QnaBoardBChuVO;
import com.hello.world.dto.QnaBoardCheckChuVO;
import com.hello.world.dto.QnaBoardChuVO;
import com.hello.world.dto.QnaBoardCommVO;
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

	@Override
	public void updateQnaBoardBChuComm(QnaBoardChuVO qnaBoardChuVO)
			throws SQLException {
		client.update("updateQnaBoardBChuComm", qnaBoardChuVO);
	}
	
	@Override
	public QnaBoardChuVO listQnaBoardChu(String qnaboard_ans_code)
			throws SQLException {
		QnaBoardChuVO qnaBoardChuVO = (QnaBoardChuVO) client
				.queryForObject("listQnaBoardChu", qnaboard_ans_code);
		
		return qnaBoardChuVO;
	}

	@Override
	public void insertCheckChu(QnaBoardCheckChuVO qnaBoardCheckChuVO)
			throws SQLException {
		
		client.insert("insertCheckChu", qnaBoardCheckChuVO);
		
	}

	@Override
	public QnaBoardCheckChuVO CheckChu(String qnaboard_ans_code)
			throws SQLException {
		
		QnaBoardCheckChuVO qnaBoardCheckChuVO = (QnaBoardCheckChuVO) client
				.queryForObject("CheckChu", qnaboard_ans_code);
		
		return qnaBoardCheckChuVO;
	}

	@Override
	public int countChu(QnaBoardCheckChuVO vo) throws SQLException {
		int cnt = (int) client
				.queryForObject("CountChu", vo);
		
		return cnt;
	}

	@Override
	public void insertCheckBChu(QnaBoardCheckChuVO qnaBoardCheckChuVO)
			throws SQLException {
		
		client.insert("insertCheckBChu", qnaBoardCheckChuVO);
		
	}

	
	

}