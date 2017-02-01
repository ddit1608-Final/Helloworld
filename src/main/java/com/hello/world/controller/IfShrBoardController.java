package com.hello.world.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.service.IfShrBoardService;

@Controller
@RequestMapping("/is")
public class IfShrBoardController {

	
	@Autowired
	IfShrBoardService ifShrBoardService;
	
	@RequestMapping("/ifShrBoardList.do")
	public String ifShareBoardList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {

		String url = "ifShrBoard/ifShrBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);

		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		ArrayList<IfShrBoardVO> ifShrBoardList = null;
		String paging = null;

		try {
			ifShrBoardList = ifShrBoardService.listAllIfShrBoard(
					Integer.parseInt(tpage), key);
			//System.out.println("테스트입니다 "+ifShrBoardList);
			paging = ifShrBoardService.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("ifShrBoardList", ifShrBoardList);
		//int n = ifShrBoardList.size();
		//model.addAttribute("ifShrBoardListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}
	
	
}
