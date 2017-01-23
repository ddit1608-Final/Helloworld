package com.hello.world.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemberVO;
import com.hello.world.service.MemberService;

//import com.nonage.dto.MemberVO;

@Controller
@RequestMapping("/free")
public class FreeBoardController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/freeBoardList.do")
	public String qnaList(HttpSession session, Model model)
			throws ServletException, IOException {
		String url = "freeBoard/freeBoardList";

		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		ArrayList<FreeBoardVO> freeBoardList = memberService.getFreeBoardList(loginUser.getMem_Mail());
		model.addAttribute("freeBoardList", freeBoardList);

		return url;
	}

	@RequestMapping("/freeBoardView.do")
	public String freeBoardView(@RequestParam("qseq") int qseq, HttpSession session,
			Model model) throws ServletException, IOException {

		String url = "freeBoard/freeBoardView";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		FreeBoardVO freeBoardVO = memberService.getFreeBoardVO(qseq);
		model.addAttribute("freeBoardVO", freeBoardVO);

		return url;
	}

	@RequestMapping("/freeBoardWriteForm.do")
	public String qnaWriteForm(HttpSession session) throws ServletException,
			IOException {
		String url = "freeBoard/freeBoardWrite";

		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		return url;
	}

	@RequestMapping("/freeBoardWrite.do")
	public String qnaWrite(@RequestParam("subject") String subject,
			@RequestParam("content") String content, HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";

		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		FreeBoardVO freeBoardVO = new FreeBoardVO(url, url, url, url, url, null, 0, url);
		freeBoardVO.setSubject(subject);
		freeBoardVO.setContent(content);
		memberService.insertFreeBoard(freeBoardVO, loginUser.getMem_Mail());

		return url;
	}
}
