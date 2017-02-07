package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.testVO;


public interface FreeBoardDAO {  
	
	// 상세
	public FreeBoardVO getFreeDetail(String freeboard_posting_no)throws SQLException;
	// 추가
	public int insertFreeBoard(FreeBoardVO freeBoardVO)throws SQLException;
	// 전체리스트
	public ArrayList<FreeBoardVO> listAllFreeBoard(int startRow, String freeboard_title, int counts)throws SQLException;
	// 수정
	public void updateFreeBoard(FreeBoardVO freeBoardVO)throws SQLException;
	// 삭제
	public void deleteFreeBoard(String freeBoardVO)throws SQLException;
	// 전체 페이징
	public int totalRecord(testVO testVO)throws SQLException;
	// 카운트 페이징
	public int getTotal(testVO testVO)throws SQLException;
	// 조회수
	public void updateFreeHits(FreeBoardVO freeBoardVO)throws SQLException;
	// 검색
	public ArrayList<FreeBoardVO> getFreeBoardList(int startRow, testVO testVO,int counts)throws SQLException;
}


