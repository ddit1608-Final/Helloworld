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

import com.hello.world.dto.DogBoardVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.PostingTypeVO;
import com.hello.world.dto.QnaBoardBChuVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.DogBoardService;
import com.hello.world.service.FreeBoardService;
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
	private NaverNewsService service;
	
	
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
		
		
		return url;
		
		
	}
	@RequestMapping(value="googleAPI",method=RequestMethod.GET)
	public String test(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {
	 String url= "../../googleAPI";
	 
	 return url;
	}
}
