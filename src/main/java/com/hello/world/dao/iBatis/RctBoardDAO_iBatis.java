package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.RctBoardDAO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.RctBoardVO;
import com.hello.world.dto.SearchVO;
import com.hello.world.dto.rctSearchVO;
import com.hello.world.dto.testVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class RctBoardDAO_iBatis implements RctBoardDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public void insertRctBoard(RctBoardVO rctBoardVO) throws SQLException {

		client.insert("insertRctBoard", rctBoardVO);
	}

	@Override
	public ArrayList<RctBoardVO> getRctBoardList(int startRow, SearchVO searchVO,
			int counts) throws SQLException {
		ArrayList<RctBoardVO> rctBoardList = new ArrayList<RctBoardVO>();

		rctBoardList = (ArrayList<RctBoardVO>) client.queryForList(
				"getRctBoardList", searchVO, startRow, counts);

		return rctBoardList;
	}

	@Override
	public ArrayList<RctBoardVO> listAllRctBoard(int startRow, SearchVO searchVO,
			int counts) throws SQLException {
		ArrayList<RctBoardVO> rctBoardList = new ArrayList<RctBoardVO>();

		rctBoardList = (ArrayList<RctBoardVO>) client.queryForList(
				"listAllRctBoard", searchVO, startRow, counts);

		return rctBoardList;
	}

	@Override
	public int getTotal(SearchVO searchVO) throws SQLException {

		return (int) client.queryForObject("totalRctBoard", searchVO);
	}

	@Override
	public int totalRecord(SearchVO searchVO) throws SQLException {
		int total_pages = 0;
		
		total_pages = (Integer) client.queryForObject("totalRctBoard", searchVO);
		return total_pages;
	}

	@Override
	public RctBoardVO getRctDetail(String rctboard_posting_no)
			throws SQLException {
		
		RctBoardVO rctBoardVO = (RctBoardVO) client.queryForObject("rctDetail",
				rctboard_posting_no);

		return rctBoardVO;
	}

}
