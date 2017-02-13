package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.DogBoardDAO;
import com.hello.world.dto.DogBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.testVO;

public class DogBoardService {

	static int view_rows = 10;
	static int counts = 15; 

	DogBoardDAO dogBoardDAO;
	
	public void setDogBoardDAO(DogBoardDAO dogBoardDAO) {
		this.dogBoardDAO = dogBoardDAO;
	}

	public ArrayList<DogBoardVO> listAllDsBoard(int tpage,String key) throws SQLException {
		ArrayList<DogBoardVO> list = new ArrayList<DogBoardVO>();
		int startRow = -1;
		int endRow = -1;

		if (key.equals("")) {
			key = "%";
		}
		
		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType("ifshrboard_title");

		int totalRecord = dogBoardDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = dogBoardDAO.listAllDsBoard(startRow, key, counts);

		return list;
	}

	

	public String pageNumber(int tpage, testVO testVO) throws SQLException {
		String str = "";

		testVO.setKey(testVO.getKey());
		testVO.setType(testVO.getType());
		
		
		int total_pages = dogBoardDAO.totalRecord(testVO);
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
			str += "<a href='dogBoardList.do?tpage=1&key=" + testVO.getKey()
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='dogBoardList.do?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='dogBoardList.do?tpage=" + i + "&key=" + testVO.getKey()
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='dogBoardList.do?tpage=" + (end_page + 1)
					+ "&key=" + testVO.getKey() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='dogBoardList.do?tpage=" + page_count + "&key="
					+ testVO.getKey() + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	public int insertDsBoard(DogBoardVO dogBoardVO)throws SQLException{
		
		return dogBoardDAO.insertDsBoard(dogBoardVO);
	}
	
	public DogBoardVO getDsBoardDetail(String dsboard_posting_no) {
		DogBoardVO dogBoardVO = null;

		try {
			dogBoardVO = dogBoardDAO.getDsBoardDetail(dsboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dogBoardVO;
	}
	
	public void updateDsBoard(DogBoardVO dogBoardVO){
		
		try {
			dogBoardDAO.updateDsBoard(dogBoardVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteDsBoard(String dsboard_posting_no){
		try {
			dogBoardDAO.deleteDsBoard(dsboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateHits(DogBoardVO dogBoardVO){
		try {
			dogBoardDAO.updateHits(dogBoardVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<DogBoardVO> getDsBoardList(int tpage, testVO testVO )throws SQLException{
		ArrayList<DogBoardVO> list = new ArrayList<DogBoardVO>();
		int startRow = -1;
		int endRow = -1;
		
		String key = testVO.getKey(); 
		
		if (key.equals("")) {
			key = "%";
		}

		int totalRecord = dogBoardDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		//list = (ArrayList<IfShrBoardVO>) ifShrBoardDAO.getIsBoardList(startRow, key, counts);
		list = (ArrayList<DogBoardVO>) dogBoardDAO.getDsBoardList(startRow, testVO, counts);

		return list;
	}
	public int getTotal(testVO testVO)throws SQLException{
		
		return dogBoardDAO.getTotal(testVO);
		
	}
	
	
}
