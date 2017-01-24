package com.hello.world.service;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.ResmDAO;
import com.hello.world.dto.ResmVO;

public class ResmService {
	
	@Autowired
	ResmDAO resmDAO;
	
	public void setResmDAO(ResmDAO resmDAO) {
		this.resmDAO = resmDAO;
	}
	
	public void insertResm(ResmVO resmVO){
		
		
		try {
			resmDAO.insertResm(resmVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
