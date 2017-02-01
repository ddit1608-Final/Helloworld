package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.MeetBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MeetBoardVO;

public class MeetBoardService {

	static int view_rows=10;
	static int counts = 15;
	
	
	MeetBoardDAO meetBoardDAO;

	public void setMeetBoardDAO(MeetBoardDAO meetBoardDAO) {
		this.meetBoardDAO = meetBoardDAO;
	}
	
	
	public ArrayList<MeetBoardVO> listAllMeetBoard(int tpage, 
			String meet_board_title)throws SQLException{
		
		ArrayList<MeetBoardVO> list = new ArrayList<MeetBoardVO>();
		int startRow = -1;
		int endRow = -1;
		
		if(meet_board_title.equals("")){
			meet_board_title="%";
		}
		int totalRecord = meetBoardDAO.totalRecord(meet_board_title);
		
		startRow = (tpage -1)*counts;
		endRow = startRow+counts-1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		list=meetBoardDAO.listAllMeetBoard(startRow, meet_board_title, totalRecord);
				
		return list;
	}
	
	public ArrayList<MeetBoardVO> getMeetBoardList(String logID){
		ArrayList<MeetBoardVO> meetBoardList=null;
		
		try {
			meetBoardList = meetBoardDAO.listMeetBoard(logID);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return meetBoardList;
	}
	
	
	public MeetBoardVO getMeetBoardVO(String meet_board_posting_no){
		MeetBoardVO meetBoardVO = null;
		
		try {
			meetBoardVO = meetBoardDAO.getMeetBoard(meet_board_posting_no);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return meetBoardVO;
	}
	
	public void insertMeetBoard(MeetBoardVO meetBoardVO){
		
		try {
			meetBoardDAO.insertMeetBoard(meetBoardVO);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public MeetBoardVO getMeetDetail(String meet_board_posting_no){
		MeetBoardVO meetBoardVO = null;
		
		try {
			meetBoardVO = meetBoardDAO.getMeetDetail(meet_board_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meetBoardVO;
	}
	public void updateMeetBoard(MeetBoardVO meetBoardVO){
		try {
			meetBoardDAO.updateMeetBoard(meetBoardVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMeetBoard(String meet_board_posting_no){
		
		try {
			meetBoardDAO.deleteMeetBoard(meet_board_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String pageNumber(int tpage, String name) throws SQLException{
		String str="";
		
		int total_pages = meetBoardDAO.totalRecord(name);
		int page_count = total_pages/counts+1;
		
		if(total_pages%counts==0){
			page_count--;
		}
		if(tpage<1){
			tpage=1;
		}
		int start_page = tpage-(tpage%view_rows)+1;
		int end_page = start_page +(counts-1);
		
		if(end_page>page_count){
			end_page=page_count;
		}
		if(start_page>view_rows){
			str+="<a href='meetBoardList.do?tpage=1&key="+name
					+"'>&lt;&lt;</a>&nbsp;&nbsp;";
			str+="<a href='meetBoardList.do?tpage="+(start_page-1);
			str+="&key=<%=product_name%>'>&lt;</a>&nbsp;&nbsp;";
			
		}
		for(int i=start_page; i<= end_page; i++){
			if(i==tpage){
				str="<font color=red>["+i+"]&nbsp;&nbsp;</font>";
				
			}else{
				str+="<a href='meetBoardList.do?tpage="+i+"&key="+name
					 +"'>["+i+"]</a>&nbsp;&nbsp;";
			}
		}
		if(page_count>end_page){
			str+="<a href='meetBoardList.do?tpage="+(end_page+1)
					+"&key="+name+"'> &gt; </a>&nbsp;&nbsp;";
			str+="<a href='meetBoardList.do?tpage="+page_count + "&key="
					+name+"'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
	return str;	
	}
}

































