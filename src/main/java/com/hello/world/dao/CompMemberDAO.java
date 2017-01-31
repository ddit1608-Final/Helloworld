package com.hello.world.dao;

import java.sql.SQLException;

import com.hello.world.dto.CompanyMemberVO;

public interface CompMemberDAO {
	public int insertCompMember(CompanyMemberVO compMemVO) throws SQLException;
}
