package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.MemVO;
import com.hello.world.dto.PointVO;


public interface PointDAO {
	public int insertPoint(PointVO pointVO) throws SQLException;
	public int sumPoint(String mem_mail) throws SQLException;
	public ArrayList<PointVO> listMyPoint(int startRow, String mem_mail, int counts) throws SQLException;
	public int totalMyPoint(String mem_mail)throws SQLException;
	public void ChoosePoint(PointVO pointVO) throws SQLException;
	public int totalMyPoint2(String mem_mail)throws SQLException;
	public void LoginPoint(PointVO pointVO)throws SQLException;
	public PointVO selectPoint(String mem_mail) throws SQLException;
	public PointVO selectPoint2(String mem_mail) throws SQLException;
}
