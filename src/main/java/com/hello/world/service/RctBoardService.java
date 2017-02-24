package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.RctBoardDAO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.RctBoardVO;
import com.hello.world.dto.rctSearchVO;
import com.hello.world.dto.testVO;

public class RctBoardService {
	
	static int view_rows = 10; 
	static int counts = 15; 
	
	RctBoardDAO rctBoardDAO;
	
	public void setRctBoardDAO(RctBoardDAO rctBoardDAO) {
		this.rctBoardDAO = rctBoardDAO;
	}

	public void insertRctBoard(RctBoardVO rctBoardVO){		
		try {
			rctBoardDAO.insertRctBoard(rctBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<RctBoardVO> listAllRctBoard(int tpage,
			rctSearchVO rctSearchVO) throws SQLException {
		ArrayList<RctBoardVO> list = new ArrayList<RctBoardVO>();
		int startRow = -1;
		int endRow = -1;
		
//		String key = testVO.getKey();
		String area = rctSearchVO.getArea();
		if (area.equals("")) {
			area = "%";
		}
		String comp_name = rctSearchVO.getComp_name();
		if (comp_name.equals("")){
			comp_name = "%";
		}
		String Comg = rctSearchVO.getComg();
		if(Comg.equals("")){
			Comg = "%";
		}
		String grade = rctSearchVO.getGrade();
		if(grade.equals("")){
			grade = "%";
		}
		String lan = rctSearchVO.getLan();
		if(lan.equals("")){
			lan = "%";
		}
		String sal = rctSearchVO.getSal();
		if(sal.equals("")){
			sal = "%";
		}
		String title = rctSearchVO.getTitle();
		if(title.equals("")){
			title = "%";
		}

		int totalRecord = rctBoardDAO.getTotal(rctSearchVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list =  rctBoardDAO.listAllRctBoard(startRow, rctSearchVO, counts);

		return list;
	}
	
	public String pageNumber(int tpage, rctSearchVO rctSearchVO) throws SQLException {
		String str = "";

		int total_pages = rctBoardDAO.totalRecord(rctSearchVO); 
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
			str += "<a href='rctBoardList.do?tpage=1&key=" 
//		+ testVO.getKey()
					+ rctSearchVO.getTitle()
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='rctBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%="+rctSearchVO.getTitle()+"%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='rctBoardList.do?tpage=" + i + "&key=" + rctSearchVO.getTitle()
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='rctBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + rctSearchVO.getTitle() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='rctBoardList.do?tpage=" + page_count + "&key="
					+ rctSearchVO.getTitle() + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	public RctBoardVO getRctDetail(String rctboard_posting_no) {
		RctBoardVO rctBoardVO = null;

		try {
			rctBoardVO = rctBoardDAO.getRctDetail(rctboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rctBoardVO;
	}

}
