package com.hello.world.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hello.world.dto.MemVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.service.QnaBoardService;


@Controller
@RequestMapping("/qna")
public class QnaBoardController {
	
	@Autowired
	QnaBoardService qnaBoardService;
	
	@RequestMapping("/qnaBoardWriteForm.do")
	public String freeBoardWriteForm(HttpSession session)
			throws ServletException, IOException {
		String url = "qnaBoard/qnaBoardWrite";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		return url;
	}
	
	@RequestMapping("/qnaBoardWrite.do")
	public String freeBoardWrite(QnaBoardVO qnaBoardVO, HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");
		
		
		System.out.println(qnaBoardVO);
		qnaBoardService.insertQnaBoard(qnaBoardVO);

		return url;
	}

}
