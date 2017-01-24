package com.hello.world.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.ResmDAO;
import com.hello.world.dto.FreeBoardVO;
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
	
	public ArrayList<ResmVO> getResmList(String mem_mail){
		ArrayList<ResmVO> resmList=null;

		try {
			resmList = resmDAO.listResm(mem_mail);
			System.out.println(mem_mail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resmList;
	}

}
