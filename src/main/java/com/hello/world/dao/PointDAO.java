package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.MemVO;
import com.hello.world.dto.PointVO;


public interface PointDAO {
	public int insertPoint(PointVO pointVO) throws SQLException;
	public int sumPoint(String mem_mail) throws SQLException;
}
