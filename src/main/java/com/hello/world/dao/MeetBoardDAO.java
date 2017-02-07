package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.MeetBoardVO;

public interface MeetBoardDAO {

	public ArrayList<MeetBoardVO> listMeetBoard(String mem_mail) throws SQLException;
	public MeetBoardVO getMeetDetail(String meet_board_posting_no)throws SQLException;
	public MeetBoardVO getMeetBoard(String meet_board_posting_no) throws SQLException;
	public void insertMeetBoard(MeetBoardVO meetBoardVO)throws SQLException;
	public ArrayList<MeetBoardVO> listAllMeetBoard(int startRow, String meet_board_title, int counts)throws SQLException;
	public void updateMeetBoard(MeetBoardVO meetBoardVO)throws SQLException;
	public void deleteMeetBoard(String meetBoardVO)throws SQLException;
	public int totalRecord(String name)throws SQLException;
	
	
}
