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

import com.hello.world.dto.MeetBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.service.MeetBoardService;
import com.hello.world.service.MemberService;


@Controller
@RequestMapping("/meet")
public class MeetBoardController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	MeetBoardService meetService;
	
	@RequestMapping("/meetBoardList.do")
	public String MeetBoardList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException{
		
		String url="meetBoard/meetBoardList";
		String key=request.getParameter("key");
		String tpage=request.getParameter("tpage");
				
		if(key==null){
			key="";
		}
		if(tpage==null){
			tpage="1";
		}else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("key",key);
		model.addAttribute("tpage",tpage);
		
		ArrayList<MeetBoardVO> meetBoardList=null;
		String paging=null;
		
		try{
		meetBoardList = meetService.listAllMeetBoard(Integer.parseInt(tpage), key);
		paging = meetService.pageNumber(Integer.parseInt(tpage), key);
		}catch(SQLException e){
			e.printStackTrace();
		}
		model.addAttribute("meetBoardList",meetBoardList);
		int n=meetBoardList.size();
		model.addAttribute("meetBoardListSize",n);
		model.addAttribute("paging",paging);
		return url;
	}
	
	@RequestMapping("/meetBoardDetail.do")
	public String meetBoardDetail(@RequestParam String meet_board_posting_no, HttpSession session, Model model)throws ServletException, IOException{
		String url = "meetBoard/meetBoardDetail";
		
		MeetBoardVO meetBoardVO = meetService.getMeetDetail(meet_board_posting_no);
		
		model.addAttribute("meetBoardVO",meetBoardVO);
		
		
		return url;
	}
	@RequestMapping("/meetBoardWriteForm.do")
	public String meetBoardWriteForm(HttpSession session)
	throws ServletException, IOException{
		String url="meetBoard/meetBoardWrite";
		MemVO loginUser=(MemVO) session.getAttribute("loginUser");

		return url;
	}
	
	@RequestMapping("/meetBoardWrite.do")
	public String MeetBoardWrite(MeetBoardVO meetBoardVO, HttpSession session)
		throws ServletException, IOException{
		String url="redirect:meetBoardList.do";
		MemVO loginUser=(MemVO) session.getAttribute("loginUser");
		
		meetService.insertMeetBoard(meetBoardVO);
		
		return url;
	}
	@RequestMapping("/meetBoardUpdateForm.do")
	public String meetBoardUpdateForm(
			@RequestParam String meet_board_posting_no, HttpSession session, Model model)throws ServletException, IOException{
		
		String url="meetBoard/meetBoardUpdate";
		MeetBoardVO meetBoardVO = meetService.getMeetDetail(meet_board_posting_no);
		model.addAttribute("meetBoardVo",meetBoardVO);
		
		return url;
	}
	
	@RequestMapping(value="/meetBoardUpdate.do", method=RequestMethod.POST)
	public String meetBoardUpdate(MeetBoardVO meetBoardVO, HttpSession session)throws ServletException, IOException{
		String url="redirect:meetBoardList.do";
		
		MemVO loginUser = (MemVO) session.getAttribute("loginUser");
		
		meetService.updateMeetBoard(meetBoardVO);
		
		return url;
		
	}
	@RequestMapping(value="/deleteMeetBoard.do")
	public String deleteMeetBoard(@RequestParam String meet_board_posting_no,
			HttpSession session)throws ServletException, IOException{
		String url="redirect:meetBoardList.do";
		
		meetService.deleteMeetBoard(meet_board_posting_no);
		
		return url;
	}

	
	
}


































