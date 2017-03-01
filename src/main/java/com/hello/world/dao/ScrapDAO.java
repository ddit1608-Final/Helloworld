package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.ScrapVO;
import com.hello.world.dto.testVO;

public interface ScrapDAO {

	// 전체리스트
	public ArrayList<ScrapVO> listAllScrap(int startRow,String scrap_no, int counts) throws SQLException;
	// 카운트
	public int totalRecord(testVO testVO) throws SQLException;
	// 카운트
	public int getTotal(testVO testVO)throws SQLException;
	public List<ScrapVO> getScrapList(int startRow,testVO testVO,int counts)throws SQLException;
	// 추가
	public int insertScrap(ScrapVO scrapVO)throws SQLException;
}
