package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hello.world.dto.DogBoardVO;
import com.hello.world.dto.MeetBoardVO;
import com.hello.world.dto.testVO;

public interface MeetBoardDAO {

	public ArrayList<MeetBoardVO> listMeetBoard(String mem_mail) throws SQLException;
	public MeetBoardVO getMeetDetail(String meet_board_posting_no)throws SQLException;
	public MeetBoardVO getMeetBoard(String meet_board_posting_no) throws SQLException;
	public void insertMeetBoard(MeetBoardVO meetBoardVO)throws SQLException;
	public ArrayList<MeetBoardVO> listAllMeetBoard(int startRow, String meet_board_title, int counts)throws SQLException;
	public ArrayList<MeetBoardVO> listAllMeetBoardMyPage(int startRow, testVO testVO, int counts)throws SQLException;
	public void updateMeetBoard(MeetBoardVO meetBoardVO)throws SQLException;
	public void deleteMeetBoard(String meetBoardVO)throws SQLException;
	public int totalRecord(testVO testVO)throws SQLException;
	public int totalRecordMyPage(testVO testVO)throws SQLException;
	public int getTotal(testVO testVO)throws SQLException;
	
	// search
	public List<MeetBoardVO> getMtBoardList(int startRow,testVO testVO,int counts)throws SQLException;
	// read count
	public void updateHits(MeetBoardVO meetBoardVO)throws SQLException;
	
}
