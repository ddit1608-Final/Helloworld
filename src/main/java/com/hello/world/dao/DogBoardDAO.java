package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hello.world.dto.DogBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.testVO;


public interface DogBoardDAO {  
	// 전체리스트
	public ArrayList<DogBoardVO> listAllDsBoard(int startRow, String dsboard_title, int counts)throws SQLException;
	// 카운트
	public int totalRecord(testVO testVO) throws SQLException;
	// 추가
	public int insertDsBoard(DogBoardVO dogBoardVO)throws SQLException;
	// 디테일
	public DogBoardVO getDsBoardDetail(String dsboard_posting_no)throws SQLException;
	// 수정
	public void updateDsBoard(DogBoardVO dogBoardVO)throws SQLException;
	// 삭제
	public void deleteDsBoard(String dsboard_posting_no)throws SQLException;
	// 조회수
	public void updateHits(DogBoardVO dogBoardVO)throws SQLException;
	// 검색
	public List<DogBoardVO> getDsBoardList(int startRow,testVO testVO,int counts)throws SQLException;
	// 카운트
	public int getTotal(testVO testVO)throws SQLException;
	
	
}


