package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dao.iBatis.CrrDAO_iBatis;
import com.hello.world.dao.iBatis.LangDAO_iBatis;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.CrrVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.LangVO;
import com.hello.world.dto.MemVO;

@Service
public class CrrService {
	@Autowired
	private CrrDAO_iBatis crrDao;

	public void setLangDao(CrrDAO_iBatis crrDao) {
		this.crrDao = crrDao;
	}
	
	public ArrayList<CrrVO> listCrrVO() throws SQLException {
		ArrayList<CrrVO> crrList = crrDao.listCrrVO();
		return crrList;
	}

}
