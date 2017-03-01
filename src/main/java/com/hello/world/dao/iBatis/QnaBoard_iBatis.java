package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.QnaBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.testVO;
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
			testVO testVO, int counts) throws SQLException {
		ArrayList<QnaBoardVO> qnaBoardList = new ArrayList<QnaBoardVO>();

		qnaBoardList = (ArrayList<QnaBoardVO>) client.queryForList(
				"listAllQnaBoard", testVO, startRow, counts);

		return qnaBoardList;

	}
	
	@Override
	public int totalRecord(testVO testVO) throws SQLException {
		int total_pages = 0;
		String key = testVO.getKey();
		if (key.equals("")) {
			key = "%";
		}
		total_pages = (Integer) client.queryForObject("totalQnaBoard",
				testVO);
		return total_pages;
	}

	@Override
	public QnaBoardVO getQnaDetail(String qnaboard_posting_no)
			throws SQLException {
		
		QnaBoardVO qnaBoardVO = (QnaBoardVO) client.queryForObject("qnaDetail",qnaboard_posting_no);
		
		return qnaBoardVO;
		
	}

	@Override
	public ArrayList<QnaBoardVO> getQnaBoardList(int startRow, testVO testVO,
			int counts) throws SQLException {
		ArrayList<QnaBoardVO> qnaBoardList = new ArrayList<QnaBoardVO>();

		qnaBoardList = (ArrayList<QnaBoardVO>) client.queryForList(
				"getQnaBoardList", testVO, startRow, counts);

		return qnaBoardList;
	}

	@Override
	public int getTotal(testVO testVO) throws SQLException {
		
		return (int) client.queryForObject("totalQnaBoard",testVO);
		
	}

	@Override
	public void updateQnaHits(QnaBoardVO qnaBoardVO) throws SQLException {
		client.update("updateQnaHits",qnaBoardVO);		
	}
	@Override
	public void updateQnaBoard(QnaBoardVO qnaBoardVO) throws SQLException {
		client.update("updateQnaBoard",qnaBoardVO);
	}

}
