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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.world.dto.FlowVO;
import com.hello.world.dto.MeetBoardCommVO;
import com.hello.world.dto.MeetBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.NoticeVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.FlowService;
import com.hello.world.service.MeetBoardCommService;
import com.hello.world.service.MeetBoardService;
import com.hello.world.service.NoticeService;

@Controller
@RequestMapping("/meet")
public class MeetBoardController {

	@Autowired
	MeetBoardService meetService;

	@Autowired
	FlowService flowService;
	
	@Autowired
	MeetBoardCommService meetBoardCommService;
	@Autowired
	NoticeService notiSvc;

	@RequestMapping("/meetBoardList.do")
	public String MeetBoardList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {
		String total="";
		String url = "meetBoard/meetBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type = request.getParameter("type");

		if (type == null) {
			type = "";
		}

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1";
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("flowList", flowList);
		
		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);
		model.addAttribute("type", type);
		
		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType("meet_board_title");
		
		ArrayList<MeetBoardVO> meetBoardList = null;
		String paging = null;
		MeetBoardVO meetBoardVO = new MeetBoardVO();
		meetBoardVO.setFlow_code(type);
		meetBoardVO.setKey(key);
		try {
			total= meetService.getTotal(testVO)+"";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			meetBoardList = meetService.getMtBoardList(Integer.parseInt(tpage), testVO);
			paging = meetService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<NoticeVO> notiList = new ArrayList<NoticeVO>();
		
		try {
			notiList=notiSvc.listAllNotice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		model.addAttribute("notiList",notiList);
		
		
		model.addAttribute("meetBoardList", meetBoardList);
		int n = meetBoardList.size();
		model.addAttribute("meetBoardListSize", n);
		model.addAttribute("paging", paging);
		model.addAttribute("searchCnt",total);
		return url;
	}

	@RequestMapping("/meetBoardDetail.do")
	public String meetBoardDetail(@RequestParam String meet_board_posting_no,
			HttpSession session, Model model) throws ServletException,
			IOException {
		String url = "meetBoard/meetBoardDetail";
		ArrayList<MeetBoardCommVO> meetBoardCommList= new ArrayList<MeetBoardCommVO>();

		
		try {
			meetBoardCommList = meetBoardCommService.listMeetBoardComm(meet_board_posting_no);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		MeetBoardVO meetBoardVO = meetService.getMeetDetail(meet_board_posting_no);
		meetService.updateHits(meetBoardVO);
		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("flowList", flowList);
		model.addAttribute("meetBoardCommList",meetBoardCommList);
		model.addAttribute("meetBoardVO", meetBoardVO);
		model.addAttribute("meetBoardCommListCnt",meetBoardCommList.size());
		
		return url;
	}

	@RequestMapping("/meetBoardWriteForm.do")
	public String meetBoardWriteForm(HttpSession session, Model model)
			throws ServletException, IOException {
		String url = "meetBoard/meetBoardWrite";
		// MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("flowList", flowList);

		return url;
	}

	@RequestMapping("/meetBoardWrite.do")
	public String MeetBoardWrite(MeetBoardVO meetBoardVO, HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:meetBoardList.do";
		MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		meetService.insertMeetBoard(meetBoardVO);

		return url;
	}

	@RequestMapping("/meetBoardUpdateForm.do")
	public String meetBoardUpdateForm(
			@RequestParam String meet_board_posting_no, HttpSession session,
			Model model) throws ServletException, IOException {

		String url = "meetBoard/meetBoardUpdate";
		MeetBoardVO meetBoardVO = meetService
				.getMeetDetail(meet_board_posting_no);
		model.addAttribute("meetBoardVO", meetBoardVO);

		return url;
	}

	@RequestMapping(value = "/meetBoardUpdate.do", method = RequestMethod.POST)
	public String meetBoardUpdate(MeetBoardVO meetBoardVO, HttpSession session,
			Model model) throws ServletException, IOException {
		String url = "redirect:meetBoardList.do";

		
		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("flowList", flowList);

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		meetService.updateMeetBoard(meetBoardVO);

		return url;

	}

	@RequestMapping(value = "/deleteMeetBoard.do")
	public String deleteMeetBoard(@RequestParam String meet_board_posting_no,
			HttpSession session) throws ServletException, IOException {
		String url = "redirect:meetBoardList.do";

		meetService.deleteMeetBoard(meet_board_posting_no);

		return url;
	}
	@RequestMapping(value="/meetBoardSearch",method=RequestMethod.POST)
	public String getMeetBoardList(HttpServletRequest request, Model model) throws ServletException, IOException{
		String total ="";
		String url = "redirect:meetBoardList.do";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type= request.getParameter("type");
		
		if(key == null){
			key= "";
		}
		if(tpage == null){
			tpage ="1";
		}else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("key", key);
		model.addAttribute("type",type);
		model.addAttribute("tpage", tpage);
		ArrayList<MeetBoardVO> meetBoardList=null;
		String paging=null;
		
		testVO testVO = new testVO();
		
		testVO.setKey(key);
		testVO.setType(type);
		
		try {
			total = meetService.getTotal(testVO)+"";
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		try {
			meetBoardList = meetService.getMtBoardList(
					Integer.parseInt(tpage), testVO);
			paging = meetService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("meetBoardList", meetBoardList);
		int n=meetBoardList.size();
		model.addAttribute("searchCnt",total);
		model.addAttribute("paging",paging);
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
