package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hello.world.dto.DogBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.IsBoardLevelVO;
import com.hello.world.dto.PostingTypeVO;
import com.hello.world.dto.testVO;


public interface IfShrBoardDAO {  
	
	// 전체리스트
	public ArrayList<IfShrBoardVO> listAllIfShrBoard(int startRow, String ifshrboard_title, int counts)throws SQLException;
	// 카운트
	public int totalRecord(testVO testVO) throws SQLException;
	// 추가
	public int insertIfShrBoard(IfShrBoardVO ifShrBoardVO)throws SQLException;
	// 디테일
	public IfShrBoardVO getIfShrBoardDetail(String ifshrboard_posting_no)throws SQLException;
	// 수정
	public void updateIfShrBoard(IfShrBoardVO ifShrBoardVO)throws SQLException;
	// 삭제
	public void deleteIfShrBoard(String ifShrBoardVO)throws SQLException;
	// 조회수
	public void updateHits(IfShrBoardVO ifShrBoardVO)throws SQLException;
	// 검색
	public List<IfShrBoardVO> getIsBoardList(int startRow,testVO testVO,int counts)throws SQLException;
	// 카운트
	public int getTotal(testVO testVO)throws SQLException;
	
	// 솔트
	public List<IfShrBoardVO> getIsList(int startRow,PostingTypeVO typeVO,int counts)throws SQLException;
	public int totalRecordd(PostingTypeVO typeVO) throws SQLException;
	public ArrayList<IfShrBoardVO> getTotall(PostingTypeVO typeVO)throws SQLException;
	
	// 게시글 난이도
	public ArrayList<IsBoardLevelVO> getLevel() throws SQLException;
	
}


