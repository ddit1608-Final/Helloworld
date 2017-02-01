package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FlowVO;

public interface FlowDAO {
	public ArrayList<FlowVO> listFlowVO() throws SQLException;
}
