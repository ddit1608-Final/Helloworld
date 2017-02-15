package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.iBatis.CstBoard_iBatis;
import com.hello.world.dto.CstBoardCounselVO;
import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;

public class CstBoardService {
	final static int VIEW_ROWS = 10;
	final static int COUNTS = 15;

	@Autowired
	CstBoard_iBatis cstBoardDao;

	public void setCstBoardDao(CstBoard_iBatis cstBoardDao) {
		this.cstBoardDao = cstBoardDao;
	}

	public ArrayList<CstBoardCounselVO> listCstBoard(String mem_mail, int tpage, String key)
			throws SQLException {
		ArrayList<CstBoardCounselVO> cstBoardList = new ArrayList<CstBoardCounselVO>();
		int startRow = -1;
		int endRow = -1;
		
		if (key.equals("")) {
			key = "%";
		}
		
		int totalRecord = cstBoardDao.totalCstBoard(mem_mail);
		
		startRow = (tpage - 1) * COUNTS;
		endRow = startRow + COUNTS - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		cstBoardList = cstBoardDao.listCstBoard(mem_mail, startRow, COUNTS);
		return cstBoardList;
	}
	
	public ArrayList<CstBoardCounselVO> listCstBoardAdmin(int tpage, String key)
			throws SQLException {
		ArrayList<CstBoardCounselVO> cstBoardList = new ArrayList<CstBoardCounselVO>();
		int startRow = -1;
		int endRow = -1;
		
		if (key.equals("")) {
			key = "%";
		}
		
		int totalRecord = cstBoardDao.totalCstBoardAdmin();
		
		startRow = (tpage - 1) * COUNTS;
		endRow = startRow + COUNTS - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		cstBoardList = cstBoardDao.listCstBoardAdmin(startRow, COUNTS);
		return cstBoardList;
	}

	public CstBoardCounselVO getCstBoard(String cstboard_counsel_posting_no)
			throws SQLException {
		CstBoardCounselVO cstBoardVo = cstBoardDao
				.getCstBoard(cstboard_counsel_posting_no);
		return cstBoardVo;
	}

	public int insertCstBoard(CstBoardCounselVO cstBoardCounselVO)
			throws SQLException {
		int result = cstBoardDao.insertCstBoard(cstBoardCounselVO);

		return result;
	}

	public void updateCstBoard(CstBoardCounselVO cstBoardCounselVO)
			throws SQLException {
		cstBoardDao.updateCstBoard(cstBoardCounselVO);

	}

	public String cstPageNumber(int tpage, String mem_mail) throws SQLException {
		String str = "";
		String hrefStr = "cstBoardList";

		int total_pages = cstBoardDao.totalCstBoard(mem_mail);
		int page_count = total_pages / COUNTS + 1;

		if (total_pages % COUNTS == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}

		int start_page = tpage - (tpage % VIEW_ROWS) + 1;
		int end_page = start_page + (COUNTS - 1);

		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > VIEW_ROWS) {
			str += "<a href='" + hrefStr + "?tpage=1'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='" + hrefStr + "?tpage=" + (start_page - 1);
			str += "'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='" + hrefStr + "?tpage=" + i + "'>[" + i
						+ "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='" + hrefStr + "?tpage=" + (end_page + 1)
					+ "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='" + hrefStr + "?tpage=" + page_count
					+ "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

}
