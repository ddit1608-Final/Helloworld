package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.AddressVO;

public interface AddressDAO {
	public ArrayList<AddressVO> selectAddressByDong(String dong) throws SQLException;
}
