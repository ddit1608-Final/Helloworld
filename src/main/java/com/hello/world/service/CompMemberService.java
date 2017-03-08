package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dao.MemberDAO;
import com.hello.world.dao.iBatis.CompMemberDAO_iBatis;
import com.hello.world.dao.iBatis.MemberDAO_iBatis;
import com.hello.world.dto.CompanyMemberVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;

@Service
public class CompMemberService {
	@Autowired
	private CompMemberDAO_iBatis compMemDao;

	public void setCompMemDao(CompMemberDAO_iBatis compMemDao) {
		this.compMemDao = compMemDao;
	}

	public int joinCompMember(CompanyMemberVO compMemVO) throws SQLException {
		int result = compMemDao.insertCompMember(compMemVO);

		return result;
	}
	
	public CompanyMemberVO getCompanyMember(String id){
		CompanyMemberVO companyMember = null;
		try {
			companyMember = compMemDao.getCompanyMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companyMember;
	}

}
