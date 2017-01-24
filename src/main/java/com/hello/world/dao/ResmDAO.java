package com.hello.world.dao;

import java.sql.SQLException;

import com.hello.world.dto.ResmVO;

public interface ResmDAO {
	
	public void insertResm(ResmVO resmVO)throws SQLException;

}
