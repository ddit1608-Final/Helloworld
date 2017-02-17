package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.MeetBoardCommVO;
import com.hello.world.dto.MeetBoardVO;

public interface MeetBoardCommDAO {

	public int insertMeetBoardComm(MeetBoardCommVO meetBoardCommVO) throws SQLException;
	public ArrayList<MeetBoardCommVO> listMeetBoardComm(String meet_board_posting_no)throws SQLException;
	public void deleteMeetBoardComm(String meetBoardCommVO) throws SQLException;
	public void updateMeetBoardComm(MeetBoardCommVO meetBoardCommVO) throws SQLException;
	public MeetBoardCommVO getMeetBoardComm(String meet_board_ans_code) throws SQLException;
	public int getMaxSeq() throws SQLException;
	
	
}
