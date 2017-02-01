package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.MeetBoardVO;

public interface MeetBoardDAO {

	public ArrayList<MeetBoardVO> listMeetBoard(String mem_mail) throws SQLException;
	public MeetBoardVO getMeetDetail(String meet_board_posting_no)throws SQLException;
	public MeetBoardVO getMeetBoard(String meet_board_posting_no) throws SQLException;
	public void insertMeetBoard(MeetBoardVO MeetBoardVO)throws SQLException;
	public ArrayList<MeetBoardVO> listAllMeetBoard(int startRow, String meet_board_title, int counts)throws SQLException;
	public void updateMeetBoard(MeetBoardVO MeetBoardVO)throws SQLException;
	public void deleteMeetBoard(String MeetBoardVO)throws SQLException;
	public int totalRecord(String name)throws SQLException;
	
	
}
