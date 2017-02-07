package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hello.world.dao.IfShrBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.testVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class IfShrBoardDAO_iBatis implements IfShrBoardDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	@Override
	public ArrayList<IfShrBoardVO> listAllIfShrBoard(int startRow,
			String product_name, int counts) throws SQLException {
		ArrayList<IfShrBoardVO> ifShrBoardList = new ArrayList<IfShrBoardVO>();

		ifShrBoardList = (ArrayList<IfShrBoardVO>) client.queryForList(
				"ifAllIfShrBoard", startRow, counts);
		System.out.println("test입니당" + ifShrBoardList);
		return ifShrBoardList;
	}

	@Override
	public int totalRecord(testVO testVO) throws SQLException {
		int total_pages = 0;
		String key = testVO.getKey();
		if (key.equals("")) {
			key = "%";
		}
		total_pages = (Integer) client.queryForObject("totalIfShrBoard",
				testVO);
		return total_pages;
	}

	@Override
	public int insertIfShrBoard(IfShrBoardVO ifShrBoardVO) throws SQLException {
		System.out.println("다오들어왔다");
		System.out.println(ifShrBoardVO);

		int result = -1;
		if (client.insert("insertIfShrBoard", ifShrBoardVO) == null)
			result = 1;
		return result;
	}

	@Override
	public IfShrBoardVO getIfShrBoardDetail(String ifshrboard_posting_no)
			throws SQLException {
		IfShrBoardVO ifShrBoardVO = (IfShrBoardVO) client.queryForObject(
				"ifShrBoardDetail", ifshrboard_posting_no);

		return ifShrBoardVO;
	}

	@Override
	public void updateIfShrBoard(IfShrBoardVO ifShrBoardVO) throws SQLException {

		client.update("updateIfShrBoard",ifShrBoardVO);
	}

	@Override
	public void deleteIfShrBoard(String ifShrBoard_posting_no) throws SQLException {

		client.delete("deleteIfShrBoard",ifShrBoard_posting_no);
	}

	@Override
	public void updateHits(IfShrBoardVO ifShrBoardVO) throws SQLException {
		client.update("updateHits",ifShrBoardVO);
	}

	@Override
	public List<IfShrBoardVO> getIsBoardList(int startRow, testVO testVO,
			int counts) throws SQLException {
		ArrayList<IfShrBoardVO> ifShrBoardList = new ArrayList<IfShrBoardVO>();

		ifShrBoardList = (ArrayList<IfShrBoardVO>) client.queryForList(
				"getBoardByTitle", testVO, startRow, counts);

		return ifShrBoardList;
	}
	/*@Override
	public List<IfShrBoardVO> getIsBoardList(int startRow, String key,int counts) 
			throws SQLException {
		ArrayList<IfShrBoardVO> ifShrBoardList = new ArrayList<IfShrBoardVO>();

		ifShrBoardList = (ArrayList<IfShrBoardVO>) client.queryForList(
				"getBoardByTitle", key, startRow, counts);
		System.out.println(" getIsBoardList()  >>" + ifShrBoardList);
		return ifShrBoardList;
	}*/
	

	@Override
	public int getTotal(testVO testVO) throws SQLException {

		
		return (int) client.queryForObject("totalIfShrBoard", testVO);
	}






	
	
	
	

	
}
