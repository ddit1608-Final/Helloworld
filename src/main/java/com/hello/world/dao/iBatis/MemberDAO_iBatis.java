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

	/* 아래 메소드 확인 필요. 2017-01-23 jihyun.Park */
	@Override
	public int confirmID(String userid) throws SQLException {
		int result = -1;
		MemVO member = (MemVO) client.queryForObject("duplicationCheckID", userid);
		if (member != null) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}

	@Override
	public MemVO getMember(String id) throws SQLException {
		MemVO member = (MemVO) client.queryForObject("getMem", id);
		return member;
	}

	@Override
	public int insertMember(MemVO MemVO) throws SQLException {
		int result = -1;
		if (client.insert("insertMem", MemVO) != null) {
			result = -1;
		} else { // 성공
			result = 1;
		}
		return result;
	}

	/* 아래 메소드 확인 필요. 2017-01-23 jihyun.Park */
	@Override
	public int insertAuthority(MemVO MemVO) throws SQLException {
		int result = 0;
		// result = client.update("insertAuthority", MemVO);
		return result;
	}

	@Override
	public ArrayList<MemVO> listMember(String member_name) throws SQLException {
		if (member_name == "") {
			member_name = "%";
		}
		ArrayList<MemVO> memberList = (ArrayList<MemVO>) client.queryForList(
				"listMem", member_name);
		return memberList;
	}

	@Override
	public int updateMember(MemVO memVO) throws SQLException {
		int res = client.update("updateMem", memVO);
		return res;
	}

	@Override
	public int changePw(MemVO memVO) throws SQLException {
		int res = client.update("changePw", memVO);
		return res;
	}

}
