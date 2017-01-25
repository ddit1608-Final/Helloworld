package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;

public class FreeBoardService {

	static int view_rows = 10; // �������� ����
	static int counts = 15; // �� �������� ��Ÿ�� ��ǰ�� ����
	
	FreeBoardDAO freeBoardDAO;
	
	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO){
		this.freeBoardDAO=freeBoardDAO;
	}
	

	public ArrayList<FreeBoardVO> listAllFreeBoard(int tpage,
			String freeboard_title) throws SQLException {
		// ArrayList<FreeBoardVO> list = freeBoardDAO.listAllFreeBoard();
		ArrayList<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		int startRow = -1;
		int endRow = -1;

		if (freeboard_title.equals("")) {
			freeboard_title = "%";
		}

		int totalRecord = freeBoardDAO.totalRecord(freeboard_title);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		list = freeBoardDAO.listAllFreeBoard(startRow,freeboard_title,counts);

		return list;
	}
	
	public ArrayList<FreeBoardVO> getFreeBoardList(String loginID){
		ArrayList<FreeBoardVO> freeBoardList=null;

		try {

			freeBoardList = freeBoardDAO.listFreeBoard(loginID);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardList;
	}
	
	public FreeBoardVO getFreeBoardVO(String freeboard_posting_no){
		FreeBoardVO freeBoardVO = null;
		try {
			freeBoardVO = freeBoardDAO.getFreeBoard(freeboard_posting_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardVO;
	}
	
	public void insertFreeBoard(FreeBoardVO freeBoardVO){		
		try {
			freeBoardDAO.insertFreeBoard(freeBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public FreeBoardVO getFreeDetail(String freeboard_posting_no){
		FreeBoardVO freeBoardVO = null;
		
		try {
			freeBoardVO = freeBoardDAO.getFreeDetail(freeboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return freeBoardVO;
	}
	public void updateFreeBoard(FreeBoardVO freeBoardVO){		
		try {
			freeBoardDAO.updateFreeBoard(freeBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFreeBoard(String freeboard_posting_no){
		
		try {
			freeBoardDAO.deleteFreeBoard(freeboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String pageNumber(int tpage, String name) throws SQLException {
		String str = "";

		int total_pages = freeBoardDAO.totalRecord(name);
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
			str += "<a href='freeBoardList.do?tpage=1&key=" + name
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='freeBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='freeBoardList.do?tpage=" + i + "&key=" + name
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='freeBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + name + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='freeBoardList.do?tpage=" + page_count + "&key="
					+ name + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
}











