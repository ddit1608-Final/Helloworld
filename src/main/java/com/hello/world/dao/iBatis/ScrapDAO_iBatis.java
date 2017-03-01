package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hello.world.dao.ScrapDAO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.ScrapVO;
import com.hello.world.dto.testVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ScrapDAO_iBatis implements ScrapDAO{

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	@Override
	public ArrayList<ScrapVO> listAllScrap(int startRow, String scrap_no,
			int counts) throws SQLException {
		ArrayList<ScrapVO> scrapList = new ArrayList<ScrapVO>();

		scrapList = (ArrayList<ScrapVO>) client.queryForList(
				"listAllScrap", startRow, counts);
		return scrapList;
	}

	@Override
	public int totalRecord(testVO testVO) throws SQLException {
		int total_pages = 0;
		String key = testVO.getKey();
		if (key.equals("")) {
			key = "%";
		}
		total_pages = (Integer) client.queryForObject("totalScrap",
				testVO);
		return total_pages;
	}

	@Override
	public int getTotal(testVO testVO) throws SQLException {
		return (int) client.queryForObject("totalScrap", testVO);
	}

	@Override
	public int insertScrap(ScrapVO scrapVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ScrapVO> getScrapList(int startRow, testVO testVO, int counts)
			throws SQLException {
		ArrayList<ScrapVO> scrapList = new ArrayList<ScrapVO>();

		scrapList = (ArrayList<ScrapVO>) client.queryForList(
				"listAllScrap", testVO, startRow, counts);

		return scrapList;
	}

}
