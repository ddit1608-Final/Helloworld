package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.hello.world.dao.MeetBoardCommDAO;
import com.hello.world.dto.MeetBoardCommVO;

@Service
public class MeetBoardCommService {
	
	private MeetBoardCommDAO meetBoardCommDAO;
	
	public void setMeetBoardCommDAO(MeetBoardCommDAO meetBoardCommDAO){
		this.meetBoardCommDAO = meetBoardCommDAO;
	}
	
	public int insertComm(MeetBoardCommVO vo)throws SQLException{
		int result = meetBoardCommDAO.insertMeetBoardComm(vo);
		return result;
	}

	public ArrayList<MeetBoardCommVO> listMeetBoardComm(String meet_board_posting_no)throws SQLException{
		ArrayList<MeetBoardCommVO> meetBoardCommList = meetBoardCommDAO.listMeetBoardComm(meet_board_posting_no);
	
		return meetBoardCommList;
	}
	public void deleteMeetBoardComm(String meet_board_ans_code){
		
		try {
			meetBoardCommDAO.deleteMeetBoardComm(meet_board_ans_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateMeetBoardComm(MeetBoardCommVO meetBoardCommVO){
		
		try {
			meetBoardCommDAO.updateMeetBoardComm(meetBoardCommVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public MeetBoardCommVO getMeetBoardComm(String meet_board_ans_code)throws SQLException{
		return meetBoardCommDAO.getMeetBoardComm(meet_board_ans_code);
	}
	public int getMaxSeq() throws SQLException{
		return meetBoardCommDAO.getMaxSeq();
	}
	
}
