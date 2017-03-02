package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.ScrapDAO;
import com.hello.world.dto.ScrapVO;
import com.hello.world.dto.testVO;

public class ScrapService {
	
	static int view_rows = 10;
	static int counts = 15;

	ScrapDAO scrapDAO;

	public void setScrapDAO(ScrapDAO scrapDAO) {
		this.scrapDAO = scrapDAO;
	}
	
/*	public ArrayList<ScrapVO> listAllScrap(int tpage, String key)
			throws SQLException {
		ArrayList<ScrapVO> list = new ArrayList<ScrapVO>();
		int startRow = -1;
		int endRow = -1;

		if (key.equals("")) {
			key = "%";
		}

		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType("scrap_no");

		int totalRecord = scrapDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = scrapDAO.listAllScrap(startRow, key, counts);

		return list;
	}
*/
	public String pageNumber(int tpage, testVO testVO) throws SQLException {
		String str = "";

		testVO.setKey(testVO.getKey());
		testVO.setType(testVO.getType());

		int total_pages = scrapDAO.totalRecord(testVO);
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
			str += "<a href='scrapList.do?tpage=1&key=" + testVO.getKey()
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='scrapList.do?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='scrapList.do?tpage=" + i + "&key="
						+ testVO.getKey() + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='scrapList.do?tpage=" + (end_page + 1)
					+ "&key=" + testVO.getKey() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='scrapList.do?tpage=" + page_count + "&key="
					+ testVO.getKey() + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	

	public int getTotal(testVO testVO) throws SQLException {

		return scrapDAO.getTotal(testVO);

	}
	
	public ArrayList<ScrapVO> getScrapList(int tpage, testVO testVO)
			throws SQLException {
		ArrayList<ScrapVO> list = new ArrayList<ScrapVO>();
		int startRow = -1;
		int endRow = -1;
		String key = testVO.getKey();

		if (key.equals("")) {
			testVO.setKey("%");
		}

		int totalRecord = scrapDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = (ArrayList<ScrapVO>) scrapDAO.getScrapList(startRow,testVO, counts);

		return list;
	}
	

}
