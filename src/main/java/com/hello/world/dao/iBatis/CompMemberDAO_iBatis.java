package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.CompMemberDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dto.CompanyMemberVO;
import com.hello.world.dto.MemVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CompMemberDAO_iBatis implements CompMemberDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int insertCompMember(CompanyMemberVO compMemVO) throws SQLException {
		int result = -1;
		if (client.insert("insertCompMem", compMemVO) != null) {
			result = -1;
		} else { // 성공
			result = 1;
		}
		return result;
	}

}
