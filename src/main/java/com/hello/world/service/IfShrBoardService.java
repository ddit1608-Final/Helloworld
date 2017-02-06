package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.IfShrBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;

public class IfShrBoardService {

	static int view_rows = 10;
	static int counts = 15; 

	IfShrBoardDAO ifShrBoardDAO;
	
	public void setIfShrBoardDAO(IfShrBoardDAO ifShrBoardDAO) {
		this.ifShrBoardDAO = ifShrBoardDAO;
	}

	public ArrayList<IfShrBoardVO> listAllIfShrBoard(int tpage,
			String ifshrboard_title) throws SQLException {
		ArrayList<IfShrBoardVO> list = new ArrayList<IfShrBoardVO>();
		int startRow = -1;
		int endRow = -1;

		if (ifshrboard_title.equals("")) {
			ifshrboard_title = "%";
		}

		int totalRecord = ifShrBoardDAO.totalRecord(ifshrboard_title);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = ifShrBoardDAO.listAllIfShrBoard(startRow, ifshrboard_title, counts);

		return list;
	}

	

	public String pageNumber(int tpage, String name) throws SQLException {
		String str = "";

		int total_pages = ifShrBoardDAO.totalRecord(name);
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
			str += "<a href='ifShrBoardList.do?tpage=1&key=" + name
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='ifShrBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='ifShrBoardList.do?tpage=" + i + "&key=" + name
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='ifShrBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + name + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='ifShrBoardList.do?tpage=" + page_count + "&key="
					+ name + "'> &gt; &gt; </a>&nbsp;&nbsp;";
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
	
	
}
