package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.NoticeVO;

public interface NoticeDAO {
	
	public ArrayList<NoticeVO> listAllNotice() throws SQLException;
	
	public NoticeVO getNoticeDetail(String notice_id)throws SQLException;

}
