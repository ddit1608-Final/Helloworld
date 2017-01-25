package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.ResmVO;

public interface ResmDAO {
	
	public ArrayList<ResmVO> listResm(String mem_mail) throws SQLException;
	public ResmVO getResmDetail(String resm_id)throws SQLException;
	public void insertResm(ResmVO resmVO)throws SQLException;
	public void updateResm(ResmVO resmVO)throws SQLException;
	public void deleteResm(String resm_id)throws SQLException;

}
