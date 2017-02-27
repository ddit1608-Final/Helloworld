package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hello.world.dao.DogBoardDAO;
import com.hello.world.dto.DogBoardVO;
import com.hello.world.dto.PostingTypeVO;
import com.hello.world.dto.testVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class DogBoardDAO_iBatis implements DogBoardDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	@Override
	public ArrayList<DogBoardVO> listAllDsBoard(int startRow,
			String dsboard_title, int counts) throws SQLException {
		ArrayList<DogBoardVO> dsBoardList = new ArrayList<DogBoardVO>();

		dsBoardList = (ArrayList<DogBoardVO>) client.queryForList(
				"listAllDsBoard", startRow, counts);
		return dsBoardList;
	}

	@Override
	public int insertDsBoard(DogBoardVO dogBoardVO) throws SQLException {
		int result = -1;
		if (client.insert("insertDsBoard", dogBoardVO) == null)
			result = 1;
		return result;
	}

	@Override
	public DogBoardVO getDsBoardDetail(String dsboard_posting_no)
			throws SQLException {
		DogBoardVO dogBoardVO = (DogBoardVO) client.queryForObject(
				"dsBoardDetail", dsboard_posting_no);

		return dogBoardVO;
	}

	@Override
	public void updateDsBoard(DogBoardVO dogBoardVO) throws SQLException {

		client.update("updateDsBoard",dogBoardVO);
	}

	@Override
	public void deleteDsBoard(String dsboard_posting_no) throws SQLException {
		client.delete("deleteDsBoard",dsboard_posting_no);
	}

	@Override
	public void updateHits(DogBoardVO dogBoardVO) throws SQLException {
		client.update("updateDogHits",dogBoardVO);
		
	}
	// 검색
	@Override
	public List<DogBoardVO> getDsBoardList(int startRow, testVO testVO,
			int counts) throws SQLException {
		ArrayList<DogBoardVO> dogBoardList = new ArrayList<DogBoardVO>();

		dogBoardList = (ArrayList<DogBoardVO>) client.queryForList(
				"getDsBoard", testVO, startRow, counts);

		return dogBoardList;
	}


	@Override
	public int totalRecord(testVO testVO) throws SQLException {
		int total_pages = 0;
		String key = testVO.getKey();
		if (key.equals("")) {
			key = "%";
		}
		total_pages = (Integer) client.queryForObject("totalDsBoard",
				testVO);
		return total_pages;
	}


	@Override
	public int getTotal(testVO testVO) throws SQLException {
		return (int) client.queryForObject("totalDsBoard", testVO);
	}
	
	
	/// 추가
	@Override
	public List<DogBoardVO> getDogList(int startRow, PostingTypeVO typeVO, int counts)
			throws SQLException {
		ArrayList<DogBoardVO> dogBoardList = new ArrayList<DogBoardVO>();

		dogBoardList = (ArrayList<DogBoardVO>) client.queryForList(
				"getTypeList", typeVO, startRow, counts);

		return dogBoardList;
	}
	
	@Override
	public int totalRecordd(PostingTypeVO typeVO) throws SQLException {
		int total_pages = 0;
		String key = typeVO.getType_key();
		if (key.equals("")) {
			key = "%";
		}
		total_pages = (Integer) client.queryForObject("totalDsBoardd",
				typeVO);
		return total_pages;
	}


	@Override
	public ArrayList<DogBoardVO> getTotall(PostingTypeVO typeVO) throws SQLException {
		return (ArrayList<DogBoardVO>) client.queryForList("totalDsBoardd", typeVO);
	}






	
	
	
	

	
}
