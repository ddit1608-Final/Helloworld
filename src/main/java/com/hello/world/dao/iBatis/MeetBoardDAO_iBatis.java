package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.MeetBoardDAO;
import com.hello.world.dto.MeetBoardVO;
import com.hello.world.dto.testVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MeetBoardDAO_iBatis implements MeetBoardDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<MeetBoardVO> listMeetBoard(String mem_mail)
			throws SQLException {
		ArrayList<MeetBoardVO> meetBoardList = new ArrayList<MeetBoardVO>();
		meetBoardList = (ArrayList<MeetBoardVO>) client.queryForList(
				"listMeetBoard", mem_mail);
		return meetBoardList;
	}

	@Override
	public MeetBoardVO getMeetDetail(String meet_board_posting_no)
			throws SQLException {
		MeetBoardVO meetBoardVO = (MeetBoardVO) client.queryForObject(
				"getMeetBoard", meet_board_posting_no);
		return meetBoardVO;
	}

	@Override
	public MeetBoardVO getMeetBoard(String meet_board_posting_no)
			throws SQLException {
		MeetBoardVO meetBoardVO = (MeetBoardVO) client.queryForList(
				"getMeetBoard", meet_board_posting_no);
		return meetBoardVO;
	}

	@Override
	public void insertMeetBoard(MeetBoardVO MeetBoardVO) throws SQLException {
		System.out.println(MeetBoardVO);
		client.insert("insertMeetBoard", MeetBoardVO);

	}

	@Override
	public ArrayList<MeetBoardVO> listAllMeetBoard(int startRow,
			MeetBoardVO meetBoardVO, int counts) throws SQLException {
		ArrayList<MeetBoardVO> meetBoardList = new ArrayList<MeetBoardVO>();
		meetBoardList = (ArrayList<MeetBoardVO>) client.queryForList(
				"listAllMeetBoard", meetBoardVO, startRow, counts);

		return meetBoardList;
	}

	@Override
	public void updateMeetBoard(MeetBoardVO MeetBoardVO) throws SQLException {
		client.update("updateMeetBoard", MeetBoardVO);

	}

	@Override
	public void deleteMeetBoard(String meet_board_posting_no)
			throws SQLException {
		client.delete("deleteMeetBoard", meet_board_posting_no);

	}

	@Override
	public int totalRecord(MeetBoardVO meetBoardVO) throws SQLException {
		int total_pages = 0;
		if (meetBoardVO.getKey().equals("")) {
			meetBoardVO.setKey("");
		}
		total_pages = (Integer) client.queryForObject("totalMeetBoard",
				meetBoardVO);
		return total_pages;
	}

	@Override
	public int totalRecordMyPage(testVO testVO) throws SQLException {
		int total_pages = 0;
		if (testVO.getKey().equals("")) {
			testVO.setKey("");
		}
		total_pages = (Integer) client.queryForObject("totalMeetBoardMyPage",
				testVO);
		return total_pages;
	}

	@Override
	public ArrayList<MeetBoardVO> listAllMeetBoardMyPage(int startRow,
			testVO testVO, int counts) throws SQLException {
		ArrayList<MeetBoardVO> meetBoardList = new ArrayList<MeetBoardVO>();
		meetBoardList = (ArrayList<MeetBoardVO>) client.queryForList(
				"listAllMeetBoardMyPage", testVO, startRow, counts);

		return meetBoardList;
	}

}
