package com.hello.world.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hello.world.dto.MemVO;
import com.hello.world.dto.PointVO;
import com.hello.world.service.MemberService;
import com.hello.world.service.PointService;

@Controller
@RequestMapping("mypage")
public class MyPageController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PointService pointService;
	
	@RequestMapping(value = "/myBoard", method = RequestMethod.GET)
	public String myBoard() {
		String url = "myPage/myBoardList";
		
		return url;
	}
	
	@RequestMapping(value = "/updateInfo", method = RequestMethod.GET)
	public String updateInfoForm() {
		String url = "myPage/MyInfo";
		
		return url;
	}
	
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public String updateInfo(MemVO memVO, Model model, HttpSession session) {
		String url = "redirect:main";
		
		try {
			memberService.updateMember(memVO);
			session.setAttribute("loginUser", memVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping(value = "/findZipNum", method = RequestMethod.GET)
	public String findZipNum() {
		String url = "member/findZipNum";

		return url;
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String myPageMain(HttpSession session, Model model,
			HttpServletRequest request){
		
		if(session.getAttribute("loginUser") == null) {
			return "redirect:/index2.jsp";
		}
		
		String mem_mail = ((MemVO)session.getAttribute("loginUser")).getMem_mail();
		String tpage = request.getParameter("tpage");
		
		String url = "myPage/MyPageMain";
		
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		model.addAttribute("tpage", tpage);
		
		ArrayList<PointVO> myPointList = new ArrayList<PointVO>(); 
		String paging = null;
		
		try {
			myPointList = pointService.listMyPoint(mem_mail, Integer.parseInt(tpage));
			paging = pointService.pageNumber(Integer.parseInt(tpage), mem_mail);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("myPointList", myPointList);
		int n = myPointList.size();
		model.addAttribute("myPointListSize", n);
		model.addAttribute("paging", paging);
		
		return url;
	}
}
