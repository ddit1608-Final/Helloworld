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
import org.springframework.web.servlet.ModelAndView;

import com.hello.world.dto.AllBoardVO;
import com.hello.world.dto.DogBoardVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.IndexQnaVO;
import com.hello.world.dto.PostingTypeVO;
import com.hello.world.dto.QnaBoardBChuVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.AllBoardService;
import com.hello.world.service.DogBoardService;
import com.hello.world.service.FreeBoardService;
import com.hello.world.service.IfShrBoardService;
import com.hello.world.service.IndexQnaService;
import com.hello.world.service.NaverNewsService;
import com.hello.world.service.PostingService;
import com.hello.world.service.QnaBoardService;


@Controller
public class IndexController {

	
	@Autowired
	FreeBoardService freeService;
	
	@Autowired
	QnaBoardService qnaBoardService;
	
	@Autowired
	DogBoardService dogBoardService;
	
	@Autowired
	PostingService postingService;
	
	@Autowired
	IfShrBoardService ifShrBoardService;
	
	@Autowired
	AllBoardService allBoardService;
	

	@Autowired
	private NaverNewsService service;
	
	@Autowired
	IndexQnaService indexQnaService;
	
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {
		String url= "../../index2";
		FreeBoardVO free = new FreeBoardVO();
		IfShrBoardVO is = new IfShrBoardVO(); 
		QnaBoardVO qna = new QnaBoardVO();
		
		// 뉴스 영역 구현중
		ModelAndView mav = new ModelAndView();
		mav.setViewName("newsList");
		
		// test
		String total="";
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
			e1.printStackTrace();
		}
		
		ArrayList<FreeBoardVO> freeBoardList = null;
		String paging = null;

		try {
			freeBoardList = freeService.getFreeBoardList(
					Integer.parseInt(tpage), testVO);
			paging = freeService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("freeBoardList", freeBoardList);
		model.addAttribute("paging", paging);
		
		request.setAttribute("mav", mav);
		request.setAttribute("free",free );
		request.setAttribute("is",is);
		// 개소리 게시판 sample
		testVO testVO1 = new testVO();
		testVO1.setKey(key);
		testVO1.setType("dsboard_title");
		
		ArrayList<PostingTypeVO> postingList = new ArrayList<PostingTypeVO>();
		
		try {
			postingList =postingService.listPostingVO();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		model.addAttribute("postingList",postingList);
		ArrayList<PostingTypeVO> typeList = new ArrayList<PostingTypeVO>();
		try {
			typeList=postingService.listPostingVO();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		model.addAttribute("typeList",typeList);
		
		
			try {
				total= dogBoardService.getTotal(testVO1)+"";
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		

		ArrayList<DogBoardVO> dogBoardList = null;
		try {
			dogBoardList = dogBoardService.getDsBoardList(
					Integer.parseInt(tpage), testVO1);
			paging = dogBoardService.pageNumber(Integer.parseInt(tpage), testVO1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("dogBoardList", dogBoardList);
		model.addAttribute("paging", paging);
		model.addAttribute("searchCnt",total);
		
		/*qna*/
			String type = request.getParameter("type");
			if(type == null) {
				type = "qnaboard_title";
			}

			model.addAttribute("key", key);
			model.addAttribute("tpage", tpage);
			
			testVO.setKey(key);
			testVO.setType(type);

			/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

			ArrayList<IndexQnaVO> qnaBoardList = null;
			try {
				qnaBoardList = indexQnaService.IndexQna();
//				qnaBoardList = qnaBoardService.listAllQnaBoard(
//						Integer.parseInt(tpage), testVO);
				paging = qnaBoardService.pageNumber(Integer.parseInt(tpage), testVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			model.addAttribute("qnaBoardList", qnaBoardList);
			int n = qnaBoardList.size();
		
		return url;
		
		
	}
	@RequestMapping(value="googleAPI",method=RequestMethod.GET)
	public String test(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {
	 String url= "../../googleAPI";
	 
	 return url;
	}
	
	@RequestMapping(value="allBoardList",method=RequestMethod.GET)
	public String getAllSearch(HttpServletRequest request,Model model)throws ServletException, IOException{
		// jsp page는 분리된 상태
		String url="search/allSearchPage";
		
		String total = "";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type = request.getParameter("typ");
		
		
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
		ArrayList<AllBoardVO> allBoardList = null;
		String paging = null;
		
		testVO testVO = new testVO();
		
		testVO.setKey(key);
		
		try {
			total= allBoardService.getTotal(testVO)+"";
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			allBoardList = allBoardService.getAllBoardList(
					Integer.parseInt(tpage), testVO);
			paging = allBoardService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("allBoardList", allBoardList);
		int n = allBoardList.size();
		model.addAttribute("searchCnt",total);
		model.addAttribute("paging", paging);
		
	/*	switch (type) {
		case "정보공유게시판":
			testVO.setType("정보공유게시판");
			
		break;
		case "모임게시판":
			testVO.setType("모임게시판");
			
			break;
		case "질문게시판":
			testVO.setType("질문게시판");
			
			break;
		case "개발소리게시판":
			testVO.setType("개발소리게시판");
			
			break;
			
			default:
				break;
		}*/
		
		return url;
	}
	// 달력
	@RequestMapping(value="calendar",method=RequestMethod.GET)
	public String Calendar(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {
	 String url="calendar/Calendar";
	 /*String url="calendar/Calen";*/
	 
	 return url;
	}
	
	
	
	
}
