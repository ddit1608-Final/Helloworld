package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.MemberDAO;
import com.hello.world.dto.MemVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDAO_iBatis implements MemberDAO {
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public int confirmID(String userid) throws SQLException {
		int result = -1;
		MemVO member = (MemVO) client.queryForObject("confirmID", userid);
		if (member != null) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}

	@Override
	public MemVO getMember(String id) throws SQLException {
		MemVO member = (MemVO) client.queryForObject("getMember", id);
		return member;
	}

	@Override
	public int insertMember(MemVO MemVO) throws SQLException {
		int result = -1;
		if (client.insert("insertMember", MemVO) != null) {
			result = -1;
		} else {
			result = 1;
		}
		return result;
	}

	@Override
	public int insertAuthority(MemVO MemVO) throws SQLException {
		int result = 0;
		result = client.update("insertAuthority", MemVO);
		return result;
	}

	@Override
	public ArrayList<MemVO> listMember(String member_name)
			throws SQLException {
		if (member_name == "") {
			member_name = "%";
		}
		ArrayList<MemVO> memberList = (ArrayList<MemVO>) client
				.queryForList("listMember", member_name);
		return memberList;
	}

}
