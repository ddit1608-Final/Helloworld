package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.IfShrBoardDAO;
import com.hello.world.dto.IfShrBoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class IfShrBoardDAO_iBatis implements IfShrBoardDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	@Override
	public ArrayList<IfShrBoardVO> listAllIfShrBoard(int startRow,
			String product_name, int counts) throws SQLException {
		ArrayList<IfShrBoardVO> ifShrBoardList = new ArrayList<IfShrBoardVO>();
		
		ifShrBoardList = (ArrayList<IfShrBoardVO>) client.queryForList("listAllIfShrBoard",startRow,counts);
		System.out.println("test입니당"+ifShrBoardList);
		return ifShrBoardList;
	}

	@Override
	public int totalRecord(String product_name) throws SQLException {
		int total_pages=0;
		if(product_name.equals("")){
			product_name="%";
		}
		total_pages=(Integer) client.queryForObject("totalIfShrBoard",product_name);
		return total_pages;
	}

	
}