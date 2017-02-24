package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.RctBoardDAO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.RctBoardVO;
import com.hello.world.dto.rctSearchVO;
import com.hello.world.dto.testVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class RctBoardDAO_iBatis implements RctBoardDAO {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public void insertRctBoard(RctBoardVO rctBoardVO) throws SQLException {

		client.insert("insertRctBoard", rctBoardVO);
	}

	@Override
	public ArrayList<RctBoardVO> getRctBoardList(int startRow, rctSearchVO rctSearchVO,
			int counts) throws SQLException {
		ArrayList<RctBoardVO> rctBoardList = new ArrayList<RctBoardVO>();

		rctBoardList = (ArrayList<RctBoardVO>) client.queryForList(
				"getRctBoardList", rctSearchVO, startRow, counts);

		return rctBoardList;
	}

	@Override
	public ArrayList<RctBoardVO> listAllRctBoard(int startRow, rctSearchVO rctSearchVO,
			int counts) throws SQLException {
		ArrayList<RctBoardVO> rctBoardList = new ArrayList<RctBoardVO>();

		rctBoardList = (ArrayList<RctBoardVO>) client.queryForList(
				"listAllRctBoard", rctSearchVO, startRow, counts);

		return rctBoardList;
	}

	@Override
	public int getTotal(rctSearchVO rctSearchVO) throws SQLException {

		return (int) client.queryForObject("totalRctBoard", rctSearchVO);
	}

	@Override
	public int totalRecord(rctSearchVO rctSearchVO) throws SQLException {
		int total_pages = 0;
		String comp_name = rctSearchVO.getComp_name();  
		if (comp_name.equals("")) {
			comp_name = "%";
		}
		String area = rctSearchVO.getArea();
		if (area.equals("")){
			area = "%";
		}
		String lan = rctSearchVO.getLan();
		if (lan.equals("")){
			lan = "%";
		}
		String comg = rctSearchVO.getComg();
		if (comg.equals("")){
			comg = "%";
		}
		String grade = rctSearchVO.getGrade();
		if (grade.equals("")){
			grade = "%";
		}
		String sal = rctSearchVO.getSal();
		if (sal.equals("")){
			sal = "%";
		}
		String title = rctSearchVO.getTitle();
		if (title.equals("")){
			title = "%";
		}
		total_pages = (Integer) client.queryForObject("totalRctBoard", rctSearchVO);
		return total_pages;
	}

	@Override
	public RctBoardVO getRctDetail(String rctboard_posting_no)
			throws SQLException {
		
		RctBoardVO rctBoardVO = (RctBoardVO) client.queryForObject("rctDetail",
				rctboard_posting_no);

		return rctBoardVO;
	}

}
