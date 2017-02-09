package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.JobhtBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.JobhtBoardVO;
import com.hello.world.dto.testVO;

public class JobhtBoardService {
	
	static int view_rows = 10; 
	static int counts = 15; 
	
	@Autowired
	JobhtBoardDAO jobhtBoardDAO;
	
	public void setJobhtBoardDAO(JobhtBoardDAO jobhtBoardDAO){
		this.jobhtBoardDAO= jobhtBoardDAO;
	}
	
	public void insertJobthBoard(JobhtBoardVO jobhtBoardVO){		
		try {
			jobhtBoardDAO.insertJobthBoard(jobhtBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<JobhtBoardVO> listAllJobhtBoard(int tpage,
			testVO testVO) throws SQLException {

		ArrayList<JobhtBoardVO> list = new ArrayList<JobhtBoardVO>();
		int startRow = -1;
		int endRow = -1;
		
		String key = testVO.getKey(); 

		if (key.equals("")) {
			//key = "%";
			testVO.setKey("%");
		}

		int totalRecord = jobhtBoardDAO.totalRecord(testVO); 

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		list = jobhtBoardDAO.listAllJobhtBoard(startRow, testVO, counts);
		
		return list;
	}
	
	public String pageNumber(int tpage, testVO testVO) throws SQLException {
		String str = "";

		int total_pages = jobhtBoardDAO.totalRecord(testVO); 

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
			str += "<a href='jobhtBoardList.do?tpage=1&key=" + testVO.getKey()
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='jobhtBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%="+testVO.getKey()+"%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='jobhtBoardList.do?tpage=" + i + "&key=" + testVO.getKey()
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='jobhtBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + testVO.getKey() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='jobhtBoardList.do?tpage=" + page_count + "&key="
					+ testVO.getKey() + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

}
