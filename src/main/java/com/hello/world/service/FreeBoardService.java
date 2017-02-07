package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.testVO;

public class FreeBoardService {

	static int view_rows = 10; 
	static int counts = 15; 

	FreeBoardDAO freeBoardDAO;

	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}

	public ArrayList<FreeBoardVO> listAllFreeBoard(int tpage,
			String key) throws SQLException {
		// ArrayList<FreeBoardVO> list = freeBoardDAO.listAllFreeBoard();
		ArrayList<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		int startRow = -1;
		int endRow = -1;

		if (key.equals("")) {
			key = "%";
		}
		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType("freeboard_title");

		int totalRecord = freeBoardDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = freeBoardDAO.listAllFreeBoard(startRow, key, counts);

		return list;
	}


	public int insertFreeBoard(FreeBoardVO freeBoardVO) throws SQLException {
		return freeBoardDAO.insertFreeBoard(freeBoardVO);
	}

	public FreeBoardVO getFreeDetail(String freeboard_posting_no) {
		FreeBoardVO freeBoardVO = null;

		try {
			freeBoardVO = freeBoardDAO.getFreeDetail(freeboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return freeBoardVO;
	}

	public void updateFreeBoard(FreeBoardVO freeBoardVO) {
		try {
			freeBoardDAO.updateFreeBoard(freeBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFreeBoard(String freeboard_posting_no) {

		try {
			freeBoardDAO.deleteFreeBoard(freeboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String pageNumber(int tpage, testVO testVO) throws SQLException {
		String str = "";

		testVO.setKey(testVO.getKey());
		testVO.setType(testVO.getType());
		
		
		int total_pages = freeBoardDAO.totalRecord(testVO);
		int page_count = total_pages / counts + 1;

		if (total_pages % counts == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}

		int start_page = tpage - (tpage % view_rows) + 1;
		int end_page = start_page + (counts - 1);

		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<a href='freeBoardList.do?tpage=1&key=" + testVO.getKey()
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='freeBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='freeBoardList.do?tpage=" + i + "&key=" +testVO.getKey()
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='freeBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + testVO.getKey() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='freeBoardList.do?tpage=" + page_count + "&key="
					+ testVO.getKey() + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	public void updateFreeHits(FreeBoardVO freeBoardVO){
		try {
			freeBoardDAO.updateFreeHits(freeBoardVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 검색기능
	public ArrayList<FreeBoardVO> getFreeBoardList(int tpage, testVO testVO )throws SQLException{
		ArrayList<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		int startRow = -1;
		int endRow = -1;
		
		String key = testVO.getKey(); 
		
		if (key.equals("")) {
			key = "%";
		}

		int totalRecord = freeBoardDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		//list = (ArrayList<IfShrBoardVO>) ifShrBoardDAO.getIsBoardList(startRow, key, counts);
		list = (ArrayList<FreeBoardVO>) freeBoardDAO.getFreeBoardList(startRow, testVO, counts);

		return list;
	}
	public int getTotal(testVO testVO)throws SQLException{
		
		return freeBoardDAO.getTotal(testVO);
		
	}
	
	
	
	
	
}
