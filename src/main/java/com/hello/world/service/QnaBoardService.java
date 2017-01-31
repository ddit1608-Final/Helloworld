package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.QnaBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.QnaBoardVO;

public class QnaBoardService {
	
	static int view_rows = 10; 
	static int counts = 15; 
	
	QnaBoardDAO qnaBoardDAO;
	
	public void setQnaBoardDAO (QnaBoardDAO qnaBoardDAO) {
		this.qnaBoardDAO = qnaBoardDAO;		
	}
	
	public void insertQnaBoard(QnaBoardVO qnaBoardVO){		
		try {
			qnaBoardDAO.insertQnaBoard(qnaBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<QnaBoardVO> listAllQnaBoard(int tpage,
			String qnaboard_title) throws SQLException {
		// ArrayList<FreeBoardVO> list = freeBoardDAO.listAllFreeBoard();
		ArrayList<QnaBoardVO> list = new ArrayList<QnaBoardVO>();
		int startRow = -1;
		int endRow = -1;

		if (qnaboard_title.equals("")) {
			qnaboard_title = "%";
		}

		int totalRecord = qnaBoardDAO.totalRecord(qnaboard_title); 
				//freeBoardDAO.totalRecord(qnaboard_title);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list =  qnaBoardDAO.listAllQnaBoard(startRow, qnaboard_title, counts);
				//freeBoardDAO.listAllFreeBoard(startRow, freeboard_title, counts);

		return list;
	}
	
	public QnaBoardVO getQnaDetail(String qnaboard_posting_no) {
		QnaBoardVO qnaBoardVO = null;

		try {
			qnaBoardVO = qnaBoardDAO.getQnaDetail(qnaboard_posting_no); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return qnaBoardVO;
	}
	
	public String pageNumber(int tpage, String name) throws SQLException {
		String str = "";

		int total_pages = qnaBoardDAO.totalRecord(name); 
				//freeBoardDAO.totalRecord(name);
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
			str += "<a href='qnaBoardList.do?tpage=1&key=" + name
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='qnaBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='qnaBoardList.do?tpage=" + i + "&key=" + name
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='qnaBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + name + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='qnaBoardList.do?tpage=" + page_count + "&key="
					+ name + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

}
