package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hello.world.dao.WorkNetDAO;
import com.hello.world.dto.ScrapVO;
import com.hello.world.dto.WorkVO;
import com.hello.world.dto.testVO;


public class WorkNetService {


	static int view_rows = 10;
	static int counts = 15;

	
	WorkNetDAO workNetDAO;

	public void setWorkNetDAO(WorkNetDAO workNetDAO) {
		this.workNetDAO = workNetDAO;
	}
	
	public Map<String, Object> insertScrap(WorkVO[] wanted,String mem_mail)  {
		int sum = 0;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int fail = 0;
		/*for(WorkVO tmp : wanted){*/
		for(int i=0; i< wanted.length; i++){
			try{
			sum += workNetDAO.insertScrap(wanted[i],mem_mail);
			System.out.println(i+"번째 들어가는중"+wanted[i]);
			}catch(SQLException e){
				fail++;
				resultMap.put("failMessage", "중복된 스크랩");
				System.err.println("동일인의 동일채용건이 이미 스크랩된 상태");
				continue;
			}
		}
		resultMap.put("success", sum);
		resultMap.put("fail", fail);
		
		return resultMap;
	}
	// 이곳부터 스크랩 리스트 영역
	public String pageNumber(int tpage, testVO testVO) throws SQLException {
		String str = "";

		testVO.setKey(testVO.getKey());
		testVO.setType(testVO.getType());

		int total_pages = workNetDAO.totalRecord(testVO);
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
			str += "<a href='myScrapList?tpage=1&key=" + testVO.getKey()
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='myScrapList?tpage=" + (start_page - 1);
			str += "&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='myScrapList?tpage=" + i + "&key="
						+ testVO.getKey() + "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='myScrapList?tpage=" + (end_page + 1)
					+ "&key=" + testVO.getKey() + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='myScrapList?tpage=" + page_count + "&key="
					+ testVO.getKey() + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	public int getTotal(testVO testVO) throws SQLException {

		return workNetDAO.getTotal(testVO);
	}
	public ArrayList<WorkVO> getScrapList(int tpage, testVO testVO)
			throws SQLException {
		ArrayList<WorkVO> list = new ArrayList<WorkVO>();
		int startRow = -1;
		int endRow = -1;
		String key = testVO.getKey();

		if (key.equals("")) {
			testVO.setKey("%");
		}

		int totalRecord = workNetDAO.totalRecord(testVO);

		startRow = (tpage - 1) * counts;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;

		list = (ArrayList<WorkVO>) workNetDAO.getScrapList(startRow,testVO, counts);

		return list;
	}
	public void deleteScrap(String wantedAuthNo)throws SQLException{
		
		workNetDAO.deleteScrap(wantedAuthNo);
		
	}
	
	

	
	
}
