package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hello.world.dao.iBatis.FlowDAO_iBatis;
import com.hello.world.dto.FlowVO;

@Service
public class FlowService {
	@Autowired
	private FlowDAO_iBatis flowDao;

	public void setFlowDao(FlowDAO_iBatis flowDao) {
		this.flowDao = flowDao;
	}

	public ArrayList<FlowVO> listFlowVO() throws SQLException {
		ArrayList<FlowVO> langList = flowDao.listFlowVO();
		return langList;
	}

}
