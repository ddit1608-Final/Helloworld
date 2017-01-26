package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dao.PointDAO;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.PointVO;

@Service
public class PointService {
	@Autowired
	private PointDAO pointDAO;

	public void setPointDAO(PointDAO pointDAO) {
		this.pointDAO = pointDAO;
	}

	public int insertPoint(PointVO pointVO) throws SQLException {
		int result = pointDAO.insertPoint(pointVO);

		return result;
	}
	
	public int sumPoint(String mem_mail) throws SQLException {
		int sum = pointDAO.sumPoint(mem_mail);
		
		return sum;
	}

}
