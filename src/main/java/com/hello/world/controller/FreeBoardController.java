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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.service.FreeBoardCommService;
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

	@Autowired
	FreeBoardCommService freeBoardCommService;

	@RequestMapping("/freeBoardList.do")
	public String freeBoardList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {

		String url = "freeBoard/freeBoardList";
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

		ArrayList<FreeBoardVO> freeBoardList = null;
		String paging = null;

		try {
			freeBoardList = freeService.listAllFreeBoard(
					Integer.parseInt(tpage), key);
			paging = freeService.pageNumber(Integer.parseInt(tpage), key);
			// System.out.println("테스트용 컨트롤러");
			// System.out.println(freeBoardList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("freeBoardList", freeBoardList);
		int n = freeBoardList.size();
		model.addAttribute("freeBoardListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}

	@RequestMapping("/freeBoardDetail.do")
	public String freeBoardDetail(@RequestParam String freeboard_posting_no,
			HttpSession session, Model model) throws ServletException,
			IOException {
		String url = "freeBoard/freeBoardDetail";
		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		ArrayList<FreeBoardCommVO> freeBoardCommList = new ArrayList<FreeBoardCommVO>();
		FreeBoardVO freeBoardVO = freeService
				.getFreeDetail(freeboard_posting_no);

		try {
			freeBoardCommList = freeBoardCommService.listFreeBoardComm(freeboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// FreeBoardCommVO freeBoardCommVO =
		// freeService.getFreeDetail(freeboard_posting_no, freebaord_ans_code);
		System.out.println("자유게시글 상세보기 입장 !!!");
		model.addAttribute("freeBoardVO", freeBoardVO);
		System.out.println("상세보기 >> " + freeBoardVO);
		model.addAttribute("freeBoardCommList", freeBoardCommList);
		model.addAttribute("freeBoardCommListCnt", freeBoardCommList.size());
		return url;
	}

	@RequestMapping("/freeBoardWriteForm.do")
	public String freeBoardWriteForm(HttpSession session)
			throws ServletException, IOException {
		String url = "freeBoard/freeBoardWrite";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		return url;
	}

	@RequestMapping("/freeBoardWrite.do")
	public String freeBoardWrite(FreeBoardVO freeBoardVO, HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");
		/*
		 * FreeBoardVO freeBoardVO = new FreeBoardVO();
		 * freeBoardVO.setFreeboard_title(title);
		 * freeBoardVO.setFreeboard_cont(cont);
		 */
		System.out.println("테스트용 컨트롤러");
		System.out.println(freeBoardVO);
		/* memberService.insertFreeBoard(freeBoardVO, loginUser.getMem_mail()); */
		// memberService.insertFreeBoard(freeBoardVO,"shm@naver.com");
		freeService.insertFreeBoard(freeBoardVO);

		return url;
	}

	@RequestMapping("/freeBoardUpdateForm.do")
	public String freeBoardUpdateForm(
			@RequestParam String freeboard_posting_no, HttpSession session,
			Model model) throws ServletException, IOException {

		String url = "freeBoard/freeBoardUpdate";
		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */
		FreeBoardVO freeBoardVO = freeService
				.getFreeDetail(freeboard_posting_no);
		System.out.println("게시글 수정 폼 입장!!!");
		model.addAttribute("freeBoardVO", freeBoardVO);
		System.out.println("freeboardVO >>" + freeBoardVO);
		return url;
	}

	@RequestMapping(value = "/freeBoardUpdate.do", method = RequestMethod.POST)
	public String freeBoardUpate(FreeBoardVO freeBoardVO, HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		System.out.println("컨트롤러 ==> 게시글수정 실행");
		System.out.println(freeBoardVO);

		freeService.updateFreeBoard(freeBoardVO);

		return url;
	}

	@RequestMapping(value = "/deleteFreeBoard.do")
	public String deleteFreeBoard(@RequestParam String freeboard_posting_no,
			HttpSession session) throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";

		// MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		System.out.println("컨트롤러 ==> 게시글삭제 실행");

		freeService.deleteFreeBoard(freeboard_posting_no);

		return url;
	}

	@RequestMapping(value = "/writeComm", method = RequestMethod.POST)
	public String writeComm(FreeBoardCommVO fbcVO, Model model, String mem_mail) {
		String url = "redirect:freeBoardDetail.do?freeboard_posting_no="
				+ fbcVO.getFreeboard_posting_no();

		try {
			fbcVO.setFreeboard_comm_wri(mem_mail);
			freeBoardCommService.insertComm(fbcVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}
	@RequestMapping(value = "/deleteFreeBoardComm.do")
	public String deleteFreeBoardComm(@RequestParam String freeboard_ans_code,FreeBoardCommVO fbcVO,
			HttpSession session) throws ServletException, IOException {
		String url = "redirect:freeBoardDetail.do?freeboard_posting_no="
				+ fbcVO.getFreeboard_posting_no();
		freeBoardCommService.deleteFreeBoardComm(freeboard_ans_code);

		return url;
	}
	// 수정 구현중
	@RequestMapping(value="/freeBoardCommUpdateForm.do")
	public String updateFreeBoardComm(
			@RequestParam String freeboard_ans_code,FreeBoardCommVO freeBoardCommVO, HttpSession session,
			Model model, String commCont) throws ServletException, IOException {
		
		System.out.println("test"+freeBoardCommVO.getFreeboard_posting_no());
		freeBoardCommVO.setFreeboard_comm_cont(commCont);
		String url = "redirect:freeBoardDetail.do?freeboard_posting_no="
				+ freeBoardCommVO.getFreeboard_posting_no();
		freeBoardCommService.updateFreeBoardComm(freeBoardCommVO);
		
		return url;
	}
/*	@RequestMapping(value = "/freeBoardCommUpdateForm.do")
	public String updateFreeBoardComm(FreeBoardCommVO freeBoardCommVO, Model model, String mem_mail) throws SQLException {
		String url = "redirect:freeBoardDetail.do?freeboard_posting_no="
				+ freeBoardCommVO.getFreeboard_posting_no();

		freeBoardCommVO.setFreeboard_comm_cont(mem_mail);
		freeBoardCommService.updateFreeBoardComm(freeBoardCommVO);

		return url;
	}*/
	
	
}
