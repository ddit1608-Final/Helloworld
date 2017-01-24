package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dao.iBatis.LangDAO_iBatis;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.LangVO;
import com.hello.world.dto.MemVO;

@Service
public class LangService {
	@Autowired
	private LangDAO_iBatis langDao;

	public void setLangDao(LangDAO_iBatis langDao) {
		this.langDao = langDao;
	}
	
	public ArrayList<LangVO> listLangVO() throws SQLException {
		ArrayList<LangVO> langList = langDao.listLangVO();
		return langList;
	}

}
