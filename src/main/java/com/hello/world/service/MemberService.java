package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.testVO;

@Service
public class MemberService {
	final static int VIEW_ROWS = 10; 
	final static int COUNTS = 15; 
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;

	@Autowired
	private MemberDAO_iBatis memDao;

	public void setMemDao(MemberDAO_iBatis memDao) {
		this.memDao = memDao;
	}

	public int joinMember(MemVO memVO) throws SQLException {
		int result = memDao.insertMember(memVO);

		return result;
	}

	public void setFreeBoardDAO(FreeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}
	
	public ArrayList<MemVO> getMemberList(int tpage, String key) throws SQLException{
		ArrayList<MemVO> memberList=null;
		int startRow = -1;
		int endRow = -1;
		
		if (key.equals("")) {
			key = "%";
		}
		
		int totalMember = memDao.totalMember(key);
		
		
		memberList = memDao.listMember(key);
		
		return memberList;
	}
	
	public String pageNumber(int tpage, String key) throws SQLException {
		String str = "";

		int total_pages = memDao.totalMember(key); 
				//freeBoardDAO.totalRecord(name);
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
			str += "<a href='memberManageList?tpage=1&key=" + key
					+ "'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='memberManageList?tpage=" + (start_page - 1);
			str += "&key=<%="+key+"%>'>&lt;</a>&nbsp;&nbsp;";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			} else {
				str += "<a href='memberManageList?tpage=" + i + "&key=" + key
						+ "'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}

		if (page_count > end_page) {
			str += "<a href='memberManageList?tpage=" + (end_page + 1)
					+ "&key=" + key + "'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='memberManageList?tpage=" + page_count + "&key="
					+ key + "'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		return str;
	}
	
	public MemVO getMember(String id){
		MemVO member=null;
		try {
			member=memDao.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public int updateMember(MemVO memVO) throws SQLException{
		int result = memDao.updateMember(memVO);

		return result;
	}
	
	public int changePw(MemVO memVO) throws SQLException{
		int result = memDao.changePw(memVO);

		return result;
	}
		
	/*public ArrayList<FreeBoardVO> getFreeBoardList(String loginID){
		ArrayList<FreeBoardVO> freeBoardList=null;
		try {
			freeBoardList = freeBoardDAO.listFreeBoard(loginID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardList;
	}
	
	public FreeBoardVO getFreeBoardVO(String freeboard_posting_no){
		FreeBoardVO freeBoardVO = null;
		try {
			freeBoardVO = freeBoardDAO.getFreeBoard(freeboard_posting_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeBoardVO;
	}
	
	public void insertFreeBoard(FreeBoardVO freeBoardVO){		
		try {
			freeBoardDAO.insertFreeBoard(freeBoardVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

	public int confirmID(String userid) throws SQLException {
		int result = -1;

		result = memDao.confirmID(userid);

		return result;
	}
}
