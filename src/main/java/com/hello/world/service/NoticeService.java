package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dao.NoticeDAO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.NoticeVO;

public class NoticeService {
	
	NoticeDAO notiDAO;

	public void setNoticeDAO(NoticeDAO notiDAO) {
		this.notiDAO = notiDAO;
	}
	public ArrayList<NoticeVO> listAllNotice() throws SQLException {
		ArrayList<NoticeVO> notiList = notiDAO.listAllNotice();
		return notiList;
	}
	
	public NoticeVO getNoticeDetail(String notice_id) {
		NoticeVO noticeVO = null;

		try {
			noticeVO = notiDAO.getNoticeDetail(notice_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noticeVO;
	}
	// 공지수정
	public void updateNotice(NoticeVO notiVO){
		try {
			notiDAO.updateNotice(notiVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
