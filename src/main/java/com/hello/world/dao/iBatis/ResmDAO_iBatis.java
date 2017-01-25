package com.hello.world.dao.iBatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.world.dao.ResmDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.ResmVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ResmDAO_iBatis implements ResmDAO{
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public void insertResm(ResmVO resmVO) throws SQLException {		
		client.insert("insertResm", resmVO);
	}
	@Override
	public ArrayList<ResmVO> listResm(String mem_mail) throws SQLException {
		ArrayList<ResmVO> resmList = new ArrayList<ResmVO>();
		resmList = (ArrayList<ResmVO>)client.queryForList("listResm",mem_mail);
		return resmList;
	}
	@Override
	public ResmVO getResmDetail(String resm_id) throws SQLException {
		ResmVO resmVO = (ResmVO) client.queryForObject("ResmDetail",resm_id);
		return resmVO;
	}
	@Override
	public void updateResm(ResmVO resmVO) throws SQLException {
		
		client.update("updateResm", resmVO);
		
	}
	@Override
	public void deleteResm(String resm_id) throws SQLException {
		
		client.delete("deleteResm",resm_id);
		
	}
	
}
