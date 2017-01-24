package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.AddressDAO;
import com.hello.world.dto.AddressVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AddressDAO_iBatis implements AddressDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<AddressVO> selectAddressByDong(String dong)
			throws SQLException {
		ArrayList<AddressVO> addressList = (ArrayList<AddressVO>) client
				.queryForList("selectAddressByDong", dong);

		return addressList;

	}

}
