package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.CrrVO;
import com.hello.world.dto.LangVO;

public interface CrrDAO {
	public ArrayList<CrrVO> listCrrVO() throws SQLException;
}
