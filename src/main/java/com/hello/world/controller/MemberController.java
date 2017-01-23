package com.hello.world.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hello.world.dto.MemVO;
import com.hello.world.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService memService;
	
	public void setMemService(MemberService memService) {
		this.memService = memService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinMember(MemVO memVO, Model model) {
		String url = "";
		
		try {
			memService.joinMember(memVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return url;
	}
}
