package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.MemberVO;


public interface MemberDAO {
	public int confirmID(String userid) throws SQLException;
	public MemberVO getMember(String id) throws SQLException;
	public int insertMember(MemberVO memberVO) throws SQLException;
	public int insertAuthority(MemberVO memberVO) throws SQLException;
	public ArrayList<MemberVO> listMember(String member_name) throws SQLException;
}
