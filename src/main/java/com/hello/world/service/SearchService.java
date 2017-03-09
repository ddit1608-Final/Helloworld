package com.hello.world.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.hello.world.dao.SearchDAO;
import com.hello.world.dto.SearchVO;

public class SearchService {
	
	private SearchDAO searchDAO;
	
	public void setSearchDAO(SearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}



	public int getTotal(SearchVO searchVO) throws SQLException{
		
		int list = searchDAO.getTotal(searchVO);
		
		return list;
	}

}
