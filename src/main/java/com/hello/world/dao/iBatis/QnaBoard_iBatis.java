package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.QnaBoardDAO;
import com.hello.world.dto.FreeBoardVO;
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

	@Override
	public ArrayList<QnaBoardVO> listAllQnaBoard(int startRow,
			String qnaboard_title, int counts) throws SQLException {
		ArrayList<QnaBoardVO> qnaBoardList = new ArrayList<QnaBoardVO>();

		qnaBoardList = (ArrayList<QnaBoardVO>) client.queryForList(
				"listAllQnaBoard", startRow, counts);

		return qnaBoardList;

	}
	
	@Override
	public int totalRecord(String product_name) throws SQLException {
		int total_pages = 0;
		if (product_name.equals("")) {
			product_name = "%";
		}
		total_pages = (Integer) client.queryForObject("totalFreeBoard",
				product_name);
		return total_pages;
	}

	@Override
	public QnaBoardVO getQnaDetail(String qnaboard_posting_no)
			throws SQLException {
		
		QnaBoardVO qnaBoardVO = (QnaBoardVO) client.queryForObject("qnaDetail",qnaboard_posting_no);
		
		return qnaBoardVO;
		
	}


}
