package com.hello.world.dao;

import java.sql.SQLException;
import java.util.List;

import com.hello.world.dto.WorkVO;
import com.hello.world.dto.testVO;

public interface WorkNetDAO {

	public int insertScrap(WorkVO workVO,String mem_mail)throws SQLException;
	
	public int totalRecord(testVO testVO)throws SQLException;
	public int getTotal(testVO testVO)throws SQLException;
	
	public List<WorkVO> getScrapList(int startRow,testVO testVO,int counts)throws SQLException;
	
	
	
}
