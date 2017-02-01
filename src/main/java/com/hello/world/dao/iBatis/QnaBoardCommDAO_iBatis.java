package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.QnaBoardCommDAO;
import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.QnaBoardCommVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QnaBoardCommDAO_iBatis implements QnaBoardCommDAO {
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertQnaBoardComm(QnaBoardCommVO qnaBoardCommVO)
			throws SQLException {
		int result = -1;

		if (client.insert("insertQnaBoardComm", qnaBoardCommVO) == null)
			result = 1;

		return result;
	}

	@Override
	public ArrayList<QnaBoardCommVO> listQnaBoardComm(String qnaboard_posting_no)
			throws SQLException {
		
		ArrayList<QnaBoardCommVO> qnaBoardCommList = (ArrayList<QnaBoardCommVO>) client
				.queryForList("listQnaBoardComm", qnaboard_posting_no);
		
		return qnaBoardCommList;
	}

	@Override
	public void deleteQnaBoardComm(String qnaboard_ans_code) throws SQLException {
		client.delete("deleteQnaBoardComm",qnaboard_ans_code);
	}

	@Override
	public void updateQnaBoardComm(QnaBoardCommVO qnaBoardCommVO)
			throws SQLException {
		client.update("updateQnaBoardComm",qnaBoardCommVO);
	}

}
