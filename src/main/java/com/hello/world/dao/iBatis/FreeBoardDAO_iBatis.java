package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.FreeBoardDAO;
import com.hello.world.dto.FreeBoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FreeBoardDAO_iBatis implements FreeBoardDAO {
	
	
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<FreeBoardVO> listFreeBoard(String id) throws SQLException {
		ArrayList<FreeBoardVO> freeBoardList = new ArrayList<FreeBoardVO>();
		freeBoardList = (ArrayList<FreeBoardVO>) client.queryForList("listFreeBoard", id);
		return freeBoardList;
	}

	@Override
	public FreeBoardVO getFreeBoard(int seq) throws SQLException {
		FreeBoardVO freeBoardVO=(FreeBoardVO)client.queryForObject("getFreeBoard",seq);
		return freeBoardVO;
	}

	@Override
	public void insertFreeBoard(FreeBoardVO freeBoardVO, String session_id)
			throws SQLException {
		freeBoardVO.setMem_Mail(session_id);
		client.insert("insertfreeBoard",freeBoardVO);
	}
	
	/* *
	 * 관리자 모드에서 필요한 메소드
	 */
	
	@Override
	public ArrayList<FreeBoardVO> listAllFreeBoard() throws SQLException {
		ArrayList<FreeBoardVO> freeBoardList = new ArrayList<FreeBoardVO>();
		// 게시판의 데이터를 가지고 오는 쿼리 rep:1:게시물 2: 답변
		freeBoardList=(ArrayList<FreeBoardVO>)client.queryForList("listAllQna",null);
		return freeBoardList;
	}

	@Override
	public void updateFreeBoard(FreeBoardVO freeBoardVO) throws SQLException {
		client.update("updateQna",freeBoardVO);
	}
}
