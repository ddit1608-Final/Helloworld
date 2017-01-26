package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.JobhtBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.JobhtBoardVO;

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
			String jobhtboard_title) throws SQLException {

		ArrayList<JobhtBoardVO> list = new ArrayList<JobhtBoardVO>();
		int startRow = -1;
		int endRow = -1;

		if (jobhtboard_title.equals("")) {
			jobhtboard_title = "%";
		}

		int totalRecord = jobhtBoardDAO.totalRecord(jobhtboard_title); 

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		list = jobhtBoardDAO.listAllJobhtBoard(startRow, jobhtboard_title, counts);
		
		return list;
	}
	
	public String pageNumber(int tpage, String name) throws SQLException {
		String str = "";

		int total_pages = jobhtBoardDAO.totalRecord(name); 

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
			str += "<a href='jobhtBoardList.do?tpage=1&key=" + name
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='jobhtBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='jobhtBoardList.do?tpage=" + i + "&key=" + name
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='jobhtBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + name + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='jobhtBoardList.do?tpage=" + page_count + "&key="
					+ name + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

}
