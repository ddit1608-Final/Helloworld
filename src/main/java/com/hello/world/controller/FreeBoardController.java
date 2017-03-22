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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.NoticeVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.FreeBoardCommService;
import com.hello.world.service.FreeBoardService;
import com.hello.world.service.MemberService;
import com.hello.world.service.NoticeService;

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
	
	@Autowired
	NoticeService notiSvc;

	@RequestMapping("/freeBoardList.do")
	public String freeBoardList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {
		String total="";
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
		
		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType("freeboard_title");
		
		
		try {
			total= freeService.getTotal(testVO)+"";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<FreeBoardVO> freeBoardList = null;
		String paging = null;

		try {
			freeBoardList = freeService.getFreeBoardList(
					Integer.parseInt(tpage), testVO);
			paging = freeService.pageNumber(Integer.parseInt(tpage), testVO);
			// System.out.println("테스트용 컨트롤러");
			// System.out.println(freeBoardList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<NoticeVO> notiList = new ArrayList<NoticeVO>();
		
		try {
			notiList=notiSvc.listAllNotice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		model.addAttribute("freeBoardList", freeBoardList);
		model.addAttribute("paging", paging);
		model.addAttribute("searchCnt", total);
		model.addAttribute("notiList",notiList);

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
		freeService.updateFreeHits(freeBoardVO);

		try {
			freeBoardCommList = freeBoardCommService.listFreeBoardComm(freeboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// FreeBoardCommVO freeBoardCommVO =
		// freeService.getFreeDetail(freeboard_posting_no, freebaord_ans_code);
		model.addAttribute("freeBoardVO", freeBoardVO);
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
		
		String a =freeBoardVO.getFreeboard_cont().replace("\r\n","<br>");
		freeBoardVO.setFreeboard_cont(a);
		
		/*
		 * FreeBoardVO freeBoardVO = new FreeBoardVO();
		 * freeBoardVO.setFreeboard_title(title);
		 * freeBoardVO.setFreeboard_cont(cont);
		 */
		System.out.println("테스트용 컨트롤러");
		System.out.println(freeBoardVO);
		/* memberService.insertFreeBoard(freeBoardVO, loginUser.getMem_mail()); */
		// memberService.insertFreeBoard(freeBoardVO,"shm@naver.com");
		try {
			//	insert 성공
			if(freeService.insertFreeBoard(freeBoardVO) == 1) {
				url += "?result:success";
			}
			//실패
			else {
				url += "?result:fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping("/freeBoardUpdateForm.do")
	public String freeBoardUpdateForm(
			@RequestParam String freeboard_posting_no, HttpSession session,
			Model model) throws ServletException, IOException {

		String url = "freeBoard/freeBoardUpdate";
		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */
		FreeBoardVO freeBoardVO = freeService.getFreeDetail(freeboard_posting_no);
		
		// Enter 변환
		String a =freeBoardVO.getFreeboard_cont().replace("<br>","\r\n");
		freeBoardVO.setFreeboard_cont(a);
		model.addAttribute("freeBoardVO", freeBoardVO);
		return url;
	}

	@RequestMapping(value = "/freeBoardUpdate.do", method = RequestMethod.POST)
	public String freeBoardUpate(FreeBoardVO freeBoardVO, HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");
		
		String a =freeBoardVO.getFreeboard_cont().replace("\r\n","<br>");
		freeBoardVO.setFreeboard_cont(a);
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
	@RequestMapping(value="/freeBoardSearch.do",method=RequestMethod.POST)
	public String getFreeBoardList(HttpServletRequest request,Model model)
		throws ServletException,IOException{
		String total = "";
		String url = "freeBoard/freeBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type= request.getParameter("type");
		
		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		model.addAttribute("key", key);
		model.addAttribute("type",type);
		model.addAttribute("tpage", tpage);
		ArrayList<FreeBoardVO> freeBoardList = null;
		String paging = null;
		
		testVO testVO = new testVO();
		
		testVO.setKey(key);
		testVO.setType(type);
		
		try {
			total= freeService.getTotal(testVO)+"";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			/*isBoardList = ifShrBoardService.getIsBoardList(
					Integer.parseInt(tpage), key);*/
			freeBoardList = freeService.getFreeBoardList(
					Integer.parseInt(tpage), testVO);
			paging = freeService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("freeBoardList", freeBoardList);
		int n = freeBoardList.size();
		model.addAttribute("searchCnt",total);
		model.addAttribute("paging", paging);

		return url;
	}
	
	@RequestMapping(value="/noticeUpdate",method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String updateNotice(HttpServletRequest req)throws ServletException,IOException{
		String notice_id = req.getParameter("notice_id");
		System.out.println("zzzzzzzzzzzzzzzzzzzzz>>>>"+notice_id);
		String notice_cont = req.getParameter("notice_cont");
		NoticeVO notiVO = new NoticeVO();
		notiVO.setNotice_cont(notice_cont.trim());
		notiVO.setNotice_id(notice_id);
		notiSvc.updateNotice(notiVO);
		
		return notice_cont;
		
	}
	
	
}
