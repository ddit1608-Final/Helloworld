package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.IndexQnaVO;


public interface IndexQnaDAO {
	
	public ArrayList<IndexQnaVO> IndexQna() throws SQLException;

}
