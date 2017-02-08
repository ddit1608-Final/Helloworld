package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.QnaBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.testVO;

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
			testVO testVO) throws SQLException {
		// ArrayList<FreeBoardVO> list = freeBoardDAO.listAllFreeBoard();
		ArrayList<QnaBoardVO> list = new ArrayList<QnaBoardVO>();
		int startRow = -1;
		int endRow = -1;
		
		String key = testVO.getKey(); 

		if (key.equals("")) {
			key = "%";
		}

		int totalRecord = qnaBoardDAO.totalRecord(testVO); 
				//freeBoardDAO.totalRecord(qnaboard_title);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list =  qnaBoardDAO.listAllQnaBoard(startRow, testVO, counts);
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
	
	public String pageNumber(int tpage, testVO testVO) throws SQLException {
		String str = "";

		int total_pages = qnaBoardDAO.totalRecord(testVO); 
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
			str += "<a href='qnaBoardList.do?tpage=1&key=" + testVO.getKey()
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='qnaBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%="+testVO.getKey()+"%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='qnaBoardList.do?tpage=" + i + "&key=" + testVO.getKey()
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='qnaBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + testVO.getKey() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='qnaBoardList.do?tpage=" + page_count + "&key="
					+ testVO.getKey() + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

}
