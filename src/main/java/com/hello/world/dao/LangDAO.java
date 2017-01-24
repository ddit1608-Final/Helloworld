package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.LangVO;

public interface LangDAO {
	public ArrayList<LangVO> listLangVO() throws SQLException;
}
