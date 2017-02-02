package com.hello.world.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hello.world.dto.IsBoardCommVO;
import com.hello.world.service.IfShrBoardService;
import com.hello.world.service.IsBoardCommService;

@Controller
@RequestMapping(value="/is")
public class IsBoardCommController {

	@Autowired
	IfShrBoardService ifShrBoardService;
	
	@Autowired
	IsBoardCommService isBoardCommService;
	
	
	@RequestMapping(value = "/writeComm", method = RequestMethod.POST)
	public String writeComm(IsBoardCommVO ibcVO, Model model, String mem_nick) {
		String url = "redirect:ifShrBoardDetail.do?ifshrboard_posting_no="
				+ ibcVO.getIfshrboard_posting_no();

		try {
			ibcVO.setIfshrboard_comm_wri(mem_nick);
			isBoardCommService.insertComm(ibcVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}
	
	
}
