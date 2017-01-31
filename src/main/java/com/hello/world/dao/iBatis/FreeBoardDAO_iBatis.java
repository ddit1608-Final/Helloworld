package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FreeBoardDAO_iBatis implements FreeBoardDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<FreeBoardVO> listFreeBoard(String mem_mail)
			throws SQLException {
		ArrayList<FreeBoardVO> freeBoardList = new ArrayList<FreeBoardVO>();
		freeBoardList = (ArrayList<FreeBoardVO>) client.queryForList(
				"listFreeBoard", mem_mail);
		return freeBoardList;
	}

	@Override
	public int insertFreeBoard(FreeBoardVO freeBoardVO) throws SQLException {
		// freeBoardVO.setMem_mail(mem_mail);
		System.out.println("다오들어왔다");
		System.out.println(freeBoardVO);

		int result = -1;
		if (client.insert("insertFreeBoard", freeBoardVO) == null)
			result = 1;
		return result;
	}

	@Override
	public ArrayList<FreeBoardVO> listAllFreeBoard(int startRow,
			String product_name, int counts) throws SQLException {
		ArrayList<FreeBoardVO> freeBoardList = new ArrayList<FreeBoardVO>();
		// 게시판 데이터 가지오 오는 쿼리
		freeBoardList = (ArrayList<FreeBoardVO>) client.queryForList(
				"listAllFreeBoard", startRow, counts);

		return freeBoardList;
	}

	@Override
	public FreeBoardVO getFreeDetail(String freeboard_posting_no)
			throws SQLException {
		FreeBoardVO freeBoardVO = (FreeBoardVO) client.queryForObject(
				"freeDetail", freeboard_posting_no);

		return freeBoardVO;
	}

	// //////////////////////////////////////////////////////////미구현
	@Override
	public FreeBoardVO getFreeBoard(String freeboard_posting_no)
			throws SQLException {
		FreeBoardVO freeBoardVO = (FreeBoardVO) client.queryForObject(
				"getFreeBoard", freeboard_posting_no);
		return freeBoardVO;
	}

	@Override
	public void updateFreeBoard(FreeBoardVO freeBoardVO) throws SQLException {

		client.update("updateFreeBoard", freeBoardVO);
	}

	@Override
	public void deleteFreeBoard(String freeboard_posting_no)
			throws SQLException {
		client.delete("deleteFreeBoard", freeboard_posting_no);
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

}