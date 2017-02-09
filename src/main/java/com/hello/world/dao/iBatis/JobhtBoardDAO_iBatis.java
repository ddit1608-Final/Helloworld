package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.JobhtBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.JobhtBoardVO;
import com.hello.world.dto.ResmVO;
import com.hello.world.dto.testVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class JobhtBoardDAO_iBatis implements JobhtBoardDAO {
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}


	@Override
	public void insertJobthBoard(JobhtBoardVO jobhtBoardVO) throws SQLException {
		
		client.insert("insertJobthBoard", jobhtBoardVO);
		
	}


	@Override
	public ArrayList<JobhtBoardVO> listAllJobhtBoard(int startRow,
			testVO testVO, int counts) throws SQLException {
		
		ArrayList<JobhtBoardVO> jobhtBoardList = new ArrayList<JobhtBoardVO>();
		
		// 게시판 데이터 가지오 오는 쿼리
		jobhtBoardList = (ArrayList<JobhtBoardVO>) client.queryForList(
				"listAllJobhtBoard",testVO, startRow, counts);

		return jobhtBoardList;

	}


	@Override
	public int totalRecord(testVO testVO) throws SQLException {
		int total_pages = 0;
		String key = testVO.getKey();
		if (key.equals("")) {
			//product_name = "%";
			testVO.setKey("%");
		}
		total_pages = (Integer) client.queryForObject("totalJobhtBoard",
				testVO);
		return total_pages;
	}
	
	
	

}
