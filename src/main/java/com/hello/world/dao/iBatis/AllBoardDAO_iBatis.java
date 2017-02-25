package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hello.world.dao.AllBoardDAO;
import com.hello.world.dto.AllBoardVO;
import com.hello.world.dto.testVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AllBoardDAO_iBatis implements AllBoardDAO{

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	// 전체 검색할 쿼리
	@Override
	public List<AllBoardVO> getAllBoardList(int startRow, testVO testVO,
			int counts) throws SQLException {
		ArrayList<AllBoardVO> allBoardList = new ArrayList<AllBoardVO>();

		allBoardList = (ArrayList<AllBoardVO>) client.queryForList(
			"getAllBoard", testVO, startRow, counts);

		return allBoardList;
	
	}

	@Override
	public int totalRecord(testVO testVO) throws SQLException {
		int total_pages = 0;
		String key = testVO.getKey();
		if (key.equals("")) {
			key = "%";
		}
		total_pages = (Integer) client.queryForObject("totalAllBoard",
				testVO);
		return total_pages;
	}

	@Override
	public int getTotal(testVO testVO) throws SQLException {
		return (int) client.queryForObject("totalAllBoard", testVO);
	}
	



}
