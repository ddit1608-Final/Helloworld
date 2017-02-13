package com.hello.world.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.hello.world.dto.FlowVO;
import com.hello.world.dto.PostingTypeVO;

public interface PostingDAO {
	public ArrayList<PostingTypeVO> listPostingVO() throws SQLException;
}
