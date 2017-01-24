package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.AddressDAO;
import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.AddressVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;

@Service
public class AddressService {
	@Autowired
	private AddressDAO addressDao;

	public void setAddressDao(AddressDAO addressDao) {
		this.addressDao = addressDao;
	}

	public ArrayList<AddressVO> selectAddressByDong(String dong)
			throws SQLException {
		ArrayList<AddressVO> addressList = addressDao.selectAddressByDong(dong);

		return addressList;

	}
}
