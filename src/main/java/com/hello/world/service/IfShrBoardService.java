package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.hello.world.dao.IfShrBoardDAO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.testVO;

public class IfShrBoardService {

	static int view_rows = 10;
	static int counts = 15; 

	IfShrBoardDAO ifShrBoardDAO;
	
	public void setIfShrBoardDAO(IfShrBoardDAO ifShrBoardDAO) {
		this.ifShrBoardDAO = ifShrBoardDAO;
	}

	public ArrayList<IfShrBoardVO> listAllIfShrBoard(int tpage,String key) throws SQLException {
		ArrayList<IfShrBoardVO> list = new ArrayList<IfShrBoardVO>();
		int startRow = -1;
		int endRow = -1;

		if (key.equals("")) {
			key = "%";
		}
		
		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType("ifshrboard_title");

		int totalRecord = ifShrBoardDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = ifShrBoardDAO.listAllIfShrBoard(startRow, key, counts);

		return list;
	}

	

	public String pageNumber(int tpage, testVO testVO) throws SQLException {
		String str = "";

		testVO.setKey(testVO.getKey());
		testVO.setType(testVO.getType());
		
		
		int total_pages = ifShrBoardDAO.totalRecord(testVO);
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
			str += "<a href='ifShrBoardList.do?tpage=1&key=" + testVO.getKey()
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='ifShrBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='ifShrBoardList.do?tpage=" + i + "&key=" + testVO.getKey()
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='ifShrBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + testVO.getKey() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='ifShrBoardList.do?tpage=" + page_count + "&key="
					+ testVO.getKey() + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	public int insertIfShrBoard(IfShrBoardVO ifShrBoardVO)throws SQLException{
		
		return ifShrBoardDAO.insertIfShrBoard(ifShrBoardVO);
	}
	
	public IfShrBoardVO getIfShrBoardDetail(String ifshrboard_posting_no) {
		IfShrBoardVO ifShrBoardVO = null;

		try {
			ifShrBoardVO = ifShrBoardDAO.getIfShrBoardDetail(ifshrboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ifShrBoardVO;
	}
	
	public void updateIfShrBoard(IfShrBoardVO ifShrBoardVO){
		
		try {
			ifShrBoardDAO.updateIfShrBoard(ifShrBoardVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteIfShrBoard(String ifshrboard_posting_no){
		try {
			ifShrBoardDAO.deleteIfShrBoard(ifshrboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateHits(IfShrBoardVO ifShrBoardVO){
		try {
			ifShrBoardDAO.updateHits(ifShrBoardVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//public ArrayList<IfShrBoardVO> getIsBoardList(int tpage,String key )throws SQLException{
	public ArrayList<IfShrBoardVO> getIsBoardList(int tpage, testVO testVO )throws SQLException{
		ArrayList<IfShrBoardVO> list = new ArrayList<IfShrBoardVO>();
		int startRow = -1;
		int endRow = -1;
		
		String key = testVO.getKey(); 
		
		if (key.equals("")) {
			key = "%";
		}

		int totalRecord = ifShrBoardDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		//list = (ArrayList<IfShrBoardVO>) ifShrBoardDAO.getIsBoardList(startRow, key, counts);
		list = (ArrayList<IfShrBoardVO>) ifShrBoardDAO.getIsBoardList(startRow, testVO, counts);

		return list;
	}
	public int getTotal(testVO testVO)throws SQLException{
		
		return ifShrBoardDAO.getTotal(testVO);
		
	}
	
	
}
