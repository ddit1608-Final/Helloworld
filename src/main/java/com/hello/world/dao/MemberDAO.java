package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.MemVO;


public interface MemberDAO {
	public int confirmID(String userid) throws SQLException;
	public MemVO getMember(String id) throws SQLException;
	public int insertMember(MemVO MemVO) throws SQLException;
	public int insertAuthority(MemVO MemVO) throws SQLException;
	public ArrayList<MemVO> listMember(String member_name) throws SQLException;
}
