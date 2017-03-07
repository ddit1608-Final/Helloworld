package com.hello.world.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.NoticeDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.NoticeVO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class NoticeDAO_iBatis implements NoticeDAO{
	
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	@Override
	public ArrayList<NoticeVO> listAllNotice() throws SQLException {

		ArrayList<NoticeVO> notiList = 
				(ArrayList<NoticeVO>) client.queryForList("listAllNotice", null);
		return notiList;
	}

	@Override
	public NoticeVO getNoticeDetail(String notice_id) throws SQLException {
		NoticeVO noticeVO = (NoticeVO) client.queryForObject(
				"noticeDetail", notice_id);

		return noticeVO;
	}

	@Override
	public void updateNotice(NoticeVO noticeVO) throws SQLException {
		client.update("updateNoti",noticeVO);
	}

}
