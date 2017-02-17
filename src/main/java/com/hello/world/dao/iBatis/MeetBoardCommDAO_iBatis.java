package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.MeetBoardCommDAO;
import com.hello.world.dto.MeetBoardCommVO;
import com.hello.world.dto.MeetBoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MeetBoardCommDAO_iBatis implements MeetBoardCommDAO{

	private SqlMapClient client;
	
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	@Override
	public int insertMeetBoardComm(MeetBoardCommVO meetBoardCommVO)
			throws SQLException {
		int result = -1;
		
		if(client.insert("insertMeetBoardComm", meetBoardCommVO)==null)
			result=1;
		
		return 0;
	}

	@Override
	public ArrayList<MeetBoardCommVO> listMeetBoardComm(
			String meet_board_posting_no) throws SQLException {
		ArrayList<MeetBoardCommVO> meetBoardCommList = (ArrayList<MeetBoardCommVO>) client
				.queryForList("listMeetBoardComm",meet_board_posting_no);
		return meetBoardCommList;
	}

	@Override
	public void deleteMeetBoardComm(String meet_board_ans_code) throws SQLException {
		client.delete("deleteMeetBoardComm",meet_board_ans_code);
		
	}

	@Override
	public void updateMeetBoardComm(MeetBoardCommVO meetBoardCommVO)
			throws SQLException {
		client.update("updateMeetBoardComm",meetBoardCommVO);
		
	}

	@Override
	public MeetBoardCommVO getMeetBoardComm(String meet_board_ans_code)
			throws SQLException {
		
		return (MeetBoardCommVO) client.queryForObject("getMeetBoardComm",meet_board_ans_code);
	}

	@Override
	public int getMaxSeq() throws SQLException {

		return (int) client.queryForObject("getMeetMaxAnxCode");
	}
	
	
	

}
