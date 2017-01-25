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

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.service.FreeBoardService;
import com.hello.world.service.MemberService;

//import com.nonage.dto.MemVO;

@Controller
@RequestMapping("/free")
public class FreeBoardController {

   @Autowired
   FreeBoardService freeService;

	@RequestMapping("/freeBoardList.do")
	public String freeBoardList(HttpSession session, Model model,
			HttpServletRequest request)
			throws ServletException, IOException {

		String url = "freeBoard/freeBoardList";
		String key=request.getParameter("key");
	    String tpage=request.getParameter("tpage");

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		model.addAttribute("key",key);
		model.addAttribute("tpage",tpage);

		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		ArrayList<FreeBoardVO> freeBoardList = null;
		String paging=null;
		
		try {
			freeBoardList = freeService.listAllFreeBoard(Integer.parseInt(tpage), key);
			paging = freeService.pageNumber(Integer.parseInt(tpage), key);
			// System.out.println("테스트용 컨트롤러");
			// System.out.println(freeBoardList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("freeBoardList", freeBoardList);
		int n=freeBoardList.size();   
		model.addAttribute("freeBoardListSize", n);
		model.addAttribute("paging", paging);   

		return url;
	}

   @RequestMapping("/freeBoardDetail.do")
   public String freeBoardDetail(@RequestParam String freeboard_posting_no, HttpSession session,
         Model model) throws ServletException, IOException {

      String url = "freeBoard/freeBoardDetail";
      /*MemVO loginUser = (MemVO) session.getAttribute("loginUser");*/
      FreeBoardVO freeBoardVO = freeService.getFreeDetail(freeboard_posting_no);
      System.out.println("들어옴1");
      model.addAttribute("freeBoardVO", freeBoardVO);
      System.out.println(freeBoardVO);
      System.out.println("들어옴2");
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
	public String freeBoardWrite(FreeBoardVO freeBoardVO,
			HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");
	/*	FreeBoardVO freeBoardVO = new FreeBoardVO();
		freeBoardVO.setFreeboard_title(title);
		freeBoardVO.setFreeboard_cont(cont);*/
		System.out.println("테스트용 컨트롤러");
		System.out.println(freeBoardVO);
		/*memberService.insertFreeBoard(freeBoardVO, loginUser.getMem_mail());*/
		//memberService.insertFreeBoard(freeBoardVO,"shm@naver.com");
		freeService.insertFreeBoard(freeBoardVO);
		
		
		return url;
	}
	@RequestMapping("/freeBoardUpdateForm.do")
	public String freeBoardUpdateForm(@RequestParam String freeboard_posting_no, HttpSession session,
	         Model model) throws ServletException, IOException {

	      String url = "freeBoard/freeBoardUpdate";
	      /*MemVO loginUser = (MemVO) session.getAttribute("loginUser");*/
	      FreeBoardVO freeBoardVO = freeService.getFreeDetail(freeboard_posting_no);
	      System.out.println("들어옴1");
	      model.addAttribute("freeBoardVO", freeBoardVO);
	      System.out.println(freeBoardVO);
	      System.out.println("들어옴2");
	      return url;
	   }
	
	@RequestMapping(value="/freeBoardUpdate.do",method=RequestMethod.POST)
	public String freeBoardUpate(FreeBoardVO freeBoardVO,
			HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";
		
		MemVO loginUser = (MemVO) session.getAttribute("loginUser");
	
		System.out.println("테스트용 위치는 컨트롤러 업데이트");
		System.out.println(freeBoardVO);
	
		freeService.updateFreeBoard(freeBoardVO);
		
		
		return url;
	}
	@RequestMapping(value="/deleteFreeBoard.do")
	public String deleteFreeBoard(@RequestParam String freeboard_posting_no,
			HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:freeBoardList.do";
		
		//MemVO loginUser = (MemVO) session.getAttribute("loginUser");
	
		System.out.println("테스트용 위치는 컨트롤러 삭제");
	
		freeService.deleteFreeBoard(freeboard_posting_no);
		
		
		return url;
	}
}
