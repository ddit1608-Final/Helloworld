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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.QnaBoardChuVO;
import com.hello.world.dto.QnaBoardCommVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.service.QnaBoardChuService;
import com.hello.world.service.QnaBoardCommService;
import com.hello.world.service.QnaBoardService;


@Controller
@RequestMapping("/qna")
public class QnaBoardController {
	
	@Autowired
	QnaBoardService qnaBoardService;
	
	@Autowired
	QnaBoardCommService qnaBoardCommService;
	
	@Autowired
	QnaBoardChuService qnaBoardChuService;
	
	
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
	
	@RequestMapping("/qnaBoardList.do")
	public String freeBoardList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {

		String url = "qnaBoard/qnaBoardList";
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

		ArrayList<QnaBoardVO> qnaBoardList = null;
		String paging = null;

		try {
			qnaBoardList = qnaBoardService.listAllQnaBoard(
					Integer.parseInt(tpage), key);
			paging = qnaBoardService.pageNumber(Integer.parseInt(tpage), key);
			// System.out.println("테스트용 컨트롤러");
			// System.out.println(freeBoardList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("qnaBoardList", qnaBoardList);
		int n = qnaBoardList.size();
		model.addAttribute("qnaBoardListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}
	
	@RequestMapping("/qnaBoardDetail.do")
	public String qnaBoardDetail(@RequestParam String qnaboard_posting_no,
			HttpSession session, Model model) throws ServletException,
			IOException {
		String url = "qnaBoard/qnaBoardDetail";
		 MemVO loginUser = (MemVO) session.getAttribute("loginUser"); 

		ArrayList<QnaBoardCommVO> qnaBoardCommList = new ArrayList<QnaBoardCommVO>();
		QnaBoardVO qnaBoardVO = qnaBoardService.getQnaDetail(qnaboard_posting_no);
				//.getFreeDetail(freeboard_posting_no);

		try {
			qnaBoardCommList = qnaBoardCommService.listQnaBoardComm(qnaboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("qnaBoardVO", qnaBoardVO);
		model.addAttribute("qnaBoardCommList", qnaBoardCommList);
		model.addAttribute("qnaBoardCommListCnt", qnaBoardCommList.size());
		return url;
	}
	
	@RequestMapping(value = "/writeComm", method = RequestMethod.POST)
	public String writeComm(QnaBoardCommVO qncVO, Model model, String mem_mail, 
			QnaBoardChuVO qbcVO, String qnaboard_ans_code) {
		String url = "redirect:qnaBoardDetail.do?qnaboard_posting_no="
				+ qncVO.getQnaboard_posting_no();

		try {
			qncVO.setQnaboard_comm_wri(mem_mail);
			qnaBoardCommService.insertComm(qncVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}
	@RequestMapping(value = "/deleteqnaBoardComm.do")
	public String deleteQnaBoardComm(@RequestParam String qnaboard_ans_code,QnaBoardCommVO qncVO,
			HttpSession session) throws ServletException, IOException {
		String url = "redirect:qnaBoardDetail.do?qnaboard_posting_no="
				+ qncVO.getQnaboard_posting_no();
		qnaBoardCommService.deleteFreeBoardComm(qnaboard_ans_code);

		return url;
	}
	
	@RequestMapping(value = "/chu", method = RequestMethod.POST)
	public String boardChu(){
		
		String url = "redirect:qnaBoardList.do";
		
		
		
		return url;
	}
	
}
