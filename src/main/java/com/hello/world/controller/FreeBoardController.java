package com.hello.world.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.service.FreeBoardService;
import com.hello.world.service.MemberService;

//import com.nonage.dto.MemVO;

@Controller
@RequestMapping("/free")
public class FreeBoardController {

	@Autowired
	MemberService memberService;
	@Autowired
	FreeBoardService freeService;

	@RequestMapping("/freeBoardList.do")
	public String freeBoardList(HttpSession session, Model model)
			throws ServletException, IOException {
		String url = "freeBoard/freeBoardList";
		
		/*MemVO loginUser = (MemVO) session.getAttribute("loginUser");		*/
		
		ArrayList<FreeBoardVO> freeBoardList=null;
		try {
			freeBoardList = freeService.listAllFreeBoard();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("freeBoardList", freeBoardList);
		
		return url;
	}

	@RequestMapping("/freeBoardView.do")
	public String freeBoardView(@RequestParam("freeboard_posting_no") String freeboard_posting_no, HttpSession session,
			Model model) throws ServletException, IOException {

		String url = "freeBoard/freeBoardView";
		/*MemVO loginUser = (MemVO) session.getAttribute("loginUser");*/

		FreeBoardVO freeBoardVO = memberService.getFreeBoardVO(freeboard_posting_no);
		model.addAttribute("freeBoardVO", freeBoardVO);

		return url;
	}

	@RequestMapping("/freeBoardWriteForm.do")
	public String freeBoardWriteForm(HttpSession session) throws ServletException,
			IOException {
		String url = "freeBoard/freeBoardWrite";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		return url;
	}

	@RequestMapping("/freeBoardWrite.do")
	public String freeBoardWrite(@RequestParam("title") String title,
			@RequestParam("cont") String cont, HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");
		FreeBoardVO freeBoardVO = new FreeBoardVO();
		freeBoardVO.setFreeboard_title(title);
		freeBoardVO.setFreeboard_cont(cont);
		memberService.insertFreeBoard(freeBoardVO, loginUser.getMem_mail());

		return url;
	}
}
