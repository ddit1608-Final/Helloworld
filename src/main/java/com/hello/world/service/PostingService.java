package com.hello.world.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.world.dao.iBatis.PostingDAO_iBatis;
import com.hello.world.dto.PostingTypeVO;

@Service
public class PostingService {

	@Autowired
	private PostingDAO_iBatis postingDAO;
	
	public void setPostingDAO(PostingDAO_iBatis postingDAO){
		this.postingDAO=postingDAO;
	}
	public ArrayList<PostingTypeVO> listPostingVO() throws SQLException {
		ArrayList<PostingTypeVO> postingList = postingDAO.listPostingVO();
		return postingList;
	}

	
}
