package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.AllBoardDAO;
import com.hello.world.dao.DogBoardDAO;
import com.hello.world.dto.AllBoardVO;
import com.hello.world.dto.DogBoardVO;
import com.hello.world.dto.PostingTypeVO;
import com.hello.world.dto.testVO;

public class AllBoardService {

	static int view_rows = 10;
	static int counts = 15; 

	AllBoardDAO allBoardDAO;
	
	public void setAllBoardDAO(AllBoardDAO allBoardDAO) {
		this.allBoardDAO = allBoardDAO;
	}

	public String pageNumber(int tpage, testVO testVO) throws SQLException {
		String str = "";

		//testVO.setValue(testVO.getKey());
		
		
		int total_pages = allBoardDAO.totalRecord(testVO);
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
			str += "<a href='allBoardList?tpage=1&key=" //+ testVO.getKey()
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='allBoardList?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='allBoardList?tpage=" + i + "&key=" //+ testVO.getKey()
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='allBoardList?tpage=" + (end_page + 1)
					+ "&key=" + testVO.getKey() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='allBoardList?tpage=" + page_count + "&key="
					//+ testVO.getKey() 
					+ "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	public ArrayList<AllBoardVO> getAllBoardList(int tpage, testVO testVO )throws SQLException{
		ArrayList<AllBoardVO> list = new ArrayList<AllBoardVO>();
		int startRow = -1;
		int endRow = -1;
		
		String key = testVO.getKey(); 
		
		if (key.equals("")) {
			key = "%";
		}

		int totalRecord = allBoardDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = (ArrayList<AllBoardVO>) allBoardDAO.getAllBoardList(startRow, testVO, counts);

		return list;
	} 
	public int getTotal(testVO testVO)throws SQLException{
		
		return allBoardDAO.getTotal(testVO);
		
	}
	
	
	
	
	
	
}
