package com.hello.world.dao;

import java.sql.SQLException;

import com.hello.world.dto.CompanyMemberVO;
import com.hello.world.dto.MemVO;

public interface CompMemberDAO {
	public int insertCompMember(CompanyMemberVO compMemVO) throws SQLException;
	public CompanyMemberVO getCompanyMember(String id) throws SQLException;
}
