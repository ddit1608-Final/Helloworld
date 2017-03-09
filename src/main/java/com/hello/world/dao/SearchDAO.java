package com.hello.world.dao;

import java.sql.SQLException;

import com.hello.world.dto.SearchVO;

public interface SearchDAO {
	
	int getTotal(SearchVO searchVO)throws SQLException;

}
