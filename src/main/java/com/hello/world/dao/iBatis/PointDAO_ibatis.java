package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.PointDAO;
import com.hello.world.dto.PointVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class PointDAO_ibatis implements PointDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertPoint(PointVO pointVO) throws SQLException {
		int result = -1;
		if (client.insert("insertPoint", pointVO) != null) {
			result = -1;
		} else {
			result = 1;
		}
		return result;
	}

	@Override
	public int sumPoint(String mem_mail) throws SQLException {
		int sum = 0;

		Object ob = client.queryForObject("sumPoint", mem_mail);

		sum = (Integer) ob;

		return sum;
	}

	@Override
	public ArrayList<PointVO> listMyPoint(int startRow, String mem_mail, int counts) throws SQLException {
		ArrayList<PointVO> listMyPoint = new ArrayList<PointVO>();
		listMyPoint = (ArrayList<PointVO>) client.queryForList("selectPoint",
				mem_mail, startRow, counts);

		return listMyPoint;
	}

	@Override
	public int totalMyPoint2(String mem_mail) throws SQLException {
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalMyPoint2",
				mem_mail);
		return total_pages;
	}

	@Override
	public void ChoosePoint(PointVO pointVO) throws SQLException {
		client.update("ChoosePoint", pointVO);
	}

	@Override
	public int totalMyPoint(String mem_mail) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
