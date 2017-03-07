package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hello.world.dao.WorkNetDAO;
import com.hello.world.dto.ScrapVO;
import com.hello.world.dto.WorkVO;
import com.hello.world.dto.testVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class WorkNetDAO_iBatis implements WorkNetDAO{


	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	@Override
	public int insertScrap(WorkVO workVO,String mem_mail) throws SQLException {
		int result = -1;
		workVO.setMem_mail(mem_mail);
		if (client.insert("insertScrap", workVO) == null)
			result = 1;
		System.out.println("insert 질의중");
		return result;
	}

	@Override
	public int totalRecord(testVO testVO) throws SQLException {
		int total_pages = 0;
		String key = testVO.getKey();
		if (key.equals("")) {
			key = "%";
		}
		total_pages = (Integer) client.queryForObject("totalScrap",testVO);
		return total_pages;
	}

	@Override
	public int getTotal(testVO testVO) throws SQLException {
		return (int) client.queryForObject("totalScrap", testVO);
	}

	@Override
	public List<WorkVO> getScrapList(int startRow, testVO testVO, int counts)
			throws SQLException {
		ArrayList<WorkVO> scrapList = new ArrayList<WorkVO>();

		scrapList = (ArrayList<WorkVO>) client.queryForList("listAllScrap", testVO, startRow, counts);

		return scrapList;
	}

	@Override
	public void deleteScrap(String wantedAuthNo) throws SQLException {
		client.delete("deleteScrap",wantedAuthNo);
	}

	
}
