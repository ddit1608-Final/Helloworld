package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.RctBoardDAO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.RctBoardVO;
import com.hello.world.dto.SearchVO;
import com.hello.world.dto.rctSearchVO;
import com.hello.world.dto.testVO;

public class RctBoardService {

	static int view_rows = 10;
	static int counts = 15;

	RctBoardDAO rctBoardDAO;

	public void setRctBoardDAO(RctBoardDAO rctBoardDAO) {
		this.rctBoardDAO = rctBoardDAO;
	}

	public void insertRctBoard(RctBoardVO rctBoardVO) {
		try {
			rctBoardDAO.insertRctBoard(rctBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<RctBoardVO> listAllRctBoard(int tpage,
			SearchVO searchVO) throws SQLException {
		ArrayList<RctBoardVO> list = new ArrayList<RctBoardVO>();
		int startRow = -1;
		int endRow = -1;

		int totalRecord = rctBoardDAO.getTotal(searchVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = rctBoardDAO.listAllRctBoard(startRow, searchVO, counts);

		return list;
	}

	public String pageNumber(int tpage, SearchVO SearchVO)
			throws SQLException {
		String str = "";

		int total_pages = rctBoardDAO.totalRecord(SearchVO);
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
			str += "<a href='rctBoardList.do?tpage=1&rctboard_acdmcr="+SearchVO.getRctboard_acdmcr()
					+"&rctboard_emp_kind="+SearchVO.getRctboard_emp_kind()+"&rctboard_title="+SearchVO.getRctboard_title()
					+"&rctboard_work_time="+SearchVO.getRctboard_work_time()+"&rctboard_workp="+SearchVO.getRctboard_workp()
					+"&rctboard_year_sal="+SearchVO.getRctboard_year_sal()+"'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='rctBoardList.do?tpage=" + (start_page - 1);
			str += "&rctboard_acdmcr="+SearchVO.getRctboard_acdmcr()
					+"&rctboard_emp_kind="+SearchVO.getRctboard_emp_kind()+"&rctboard_title="+SearchVO.getRctboard_title()
					+"&rctboard_work_time="+SearchVO.getRctboard_work_time()+"&rctboard_workp="+SearchVO.getRctboard_workp()
					+"&rctboard_year_sal="+SearchVO.getRctboard_year_sal()+"'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='rctBoardList.do?tpage=" + i + "&rctboard_acdmcr="+SearchVO.getRctboard_acdmcr()
						+"&rctboard_emp_kind="+SearchVO.getRctboard_emp_kind()+"&rctboard_title="+SearchVO.getRctboard_title()
						+"&rctboard_work_time="+SearchVO.getRctboard_work_time()+"&rctboard_workp="+SearchVO.getRctboard_workp()
						+"&rctboard_year_sal="+SearchVO.getRctboard_year_sal()+"'>[" + i
						+ "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='rctBoardList.do?tpage=" + (end_page + 1) + "&rctboard_acdmcr="+SearchVO.getRctboard_acdmcr()
					+"&rctboard_emp_kind="+SearchVO.getRctboard_emp_kind()+"&rctboard_title="+SearchVO.getRctboard_title()
					+"&rctboard_work_time="+SearchVO.getRctboard_work_time()+"&rctboard_workp="+SearchVO.getRctboard_workp()
					+"&rctboard_year_sal="+SearchVO.getRctboard_year_sal()+"'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='rctBoardList.do?tpage=" + page_count + "&rctboard_acdmcr="+SearchVO.getRctboard_acdmcr()
					+"&rctboard_emp_kind="+SearchVO.getRctboard_emp_kind()+"&rctboard_title="+SearchVO.getRctboard_title()
					+"&rctboard_work_time="+SearchVO.getRctboard_work_time()+"&rctboard_workp="+SearchVO.getRctboard_workp()
					+"&rctboard_year_sal="+SearchVO.getRctboard_year_sal()+"'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

	public RctBoardVO getRctDetail(String rctboard_posting_no) {
		RctBoardVO rctBoardVO = null;

		try {
			rctBoardVO = rctBoardDAO.getRctDetail(rctboard_posting_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rctBoardVO;
	}
	
	public ArrayList<RctBoardVO> getRctBoardList(int tpage, SearchVO searchVO )throws SQLException{
		ArrayList<RctBoardVO> list = new ArrayList<RctBoardVO>();
		int startRow = -1;
		int endRow = -1;

		int totalRecord = rctBoardDAO.totalRecord(searchVO); 

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = (ArrayList<RctBoardVO>) rctBoardDAO.getRctBoardList(startRow, searchVO, counts); 

		return list;
	}

	public void deleteRctBoard(String rctboard_posting_no) {
		try {
			rctBoardDAO.deleteRctBoard(rctboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
