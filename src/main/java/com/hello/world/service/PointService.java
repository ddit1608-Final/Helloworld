package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dao.PointDAO;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.PointVO;
import com.hello.world.dto.QnaBoardBChuVO;

@Service
public class PointService {
	final static int VIEW_ROWS = 10;
	final static int COUNTS = 15;

	@Autowired
	private PointDAO pointDAO;

	public void setPointDAO(PointDAO pointDAO) {
		this.pointDAO = pointDAO;
	}

	public int insertPoint(PointVO pointVO) throws SQLException {
		int result = pointDAO.insertPoint(pointVO);

		return result;
	}

	public int sumPoint(String mem_mail) throws SQLException {
		int sum = pointDAO.sumPoint(mem_mail);

		return sum;
	}

	public void ChoosePoint(PointVO pointVO) {
		try {
			this.pointDAO.ChoosePoint(pointVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void LoginPoint(PointVO pointVO) {
		try {
			this.pointDAO.LoginPoint(pointVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PointVO> listMyPoint(String mem_mail, int tpage)
			throws SQLException {
		ArrayList<PointVO> listMyPoint = new ArrayList<PointVO>();

		int startRow = -1;
		int endRow = -1;

		int totalMyPoint = pointDAO.totalMyPoint(mem_mail);

		startRow = (tpage - 1) * COUNTS;
		endRow = startRow + COUNTS - 1;
		if (endRow > totalMyPoint)
			endRow = totalMyPoint;

		listMyPoint = pointDAO.listMyPoint(startRow, mem_mail, COUNTS);

		return listMyPoint;
	}

	public int totalMyPoint2(String mem_mail) throws SQLException {

		int totalMyPoint = pointDAO.totalMyPoint2(mem_mail);

		return totalMyPoint;
	}

	public PointVO selectPoint(String mem_mail) throws SQLException {

		PointVO pointVO = pointDAO.selectPoint(mem_mail);

		return pointVO;
	}

	public PointVO selectPoint2(String mem_mail) throws SQLException {

		PointVO pointVO = pointDAO.selectPoint2(mem_mail);

		return pointVO;
	}

	public String pageNumber(int tpage, String mem_mail) throws SQLException {
		String str = "";

		int total_pages = pointDAO.totalMyPoint(mem_mail);
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
			str += "<a href='main?tpage=1&key=" + mem_mail
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='main?tpage=" + (start_page - 1);
			str += "&key=<%=mem_mail%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='main?tpage=" + i + "&key=" + mem_mail + "'>["
						+ i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='main?tpage=" + (end_page + 1) + "&key=" + mem_mail
					+ "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='main?tpage=" + page_count + "&key=" + mem_mail
					+ "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}

}
