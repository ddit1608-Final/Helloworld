package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.IndexQnaDAO;
import com.hello.world.dto.IndexQnaVO;

public class IndexQnaService {
	
	IndexQnaDAO indexQnaDAO;

	public void setIndexQnaDAO(IndexQnaDAO indexQnaDAO) {
		this.indexQnaDAO = indexQnaDAO;
	}
	
	
	
	public ArrayList<IndexQnaVO> IndexQna() throws SQLException{
		
		ArrayList<IndexQnaVO> list = new ArrayList<IndexQnaVO>();
		
		list = indexQnaDAO.IndexQna();
		
		return list;
	}

}
