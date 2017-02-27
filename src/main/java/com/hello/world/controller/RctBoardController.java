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

import com.hello.world.dto.MemVO;
import com.hello.world.dto.QnaBoardBChuVO;
import com.hello.world.dto.QnaBoardChooseVO;
import com.hello.world.dto.QnaBoardChuVO;
import com.hello.world.dto.QnaBoardCommVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.RctBoardVO;
import com.hello.world.dto.rctSearchVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.RctBoardService;

@Controller
@RequestMapping("/rct")
public class RctBoardController {

	@Autowired
	RctBoardService rctBoardService;

	@RequestMapping("/rctBoardWriteForm.do")
	public String rctBoardWriteForm(HttpSession session)
			throws ServletException, IOException {
		String url = "rctBoard/rctBoardWirte";

		// MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		return url;
	}

	@RequestMapping("/rctBoardWrite.do")
	public String rctBoardWrite(RctBoardVO rctBoardVO, HttpSession session)
			throws ServletException, IOException {
		String url = "../../index2";

		// MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		System.out.println(rctBoardVO);
		rctBoardService.insertRctBoard(rctBoardVO);

		return url;
	}

	@RequestMapping("/rctBoardList.do")
	public String rctBoardList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {

		String url = "rctBoard/rctBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type = request.getParameter("type");

		String area = request.getParameter("area");
		String lan = request.getParameter("lan");
		String comg = request.getParameter("comg");
		String grade = request.getParameter("grade");
		String sal = request.getParameter("sal");
		String comp_name = request.getParameter("comp_name");
		String title = request.getParameter("title");

		if (area == null) {
			area = "";
		}
		if (lan == null) {
			lan = "";
		}
		if (comg == null) {
			comg = "";
		}
		if (grade == null) {
			grade = "";
		}
		if (sal == null) {
			sal = "";
		}
		if (comp_name == null) {
			comp_name = "";
		}
		if (title == null) {
			title = "";
		}

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		if (type == null) {
			type = "rctboard_title";
		}

		rctSearchVO rctSearchVO = new rctSearchVO();
		rctSearchVO.setArea(area);
		rctSearchVO.setComg(comg);
		rctSearchVO.setComp_name(comp_name);
		rctSearchVO.setGrade(grade);
		rctSearchVO.setLan(lan);
		rctSearchVO.setSal(sal);
		rctSearchVO.setTitle(title);

		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);

		// testVO testVO = new testVO();
		// testVO.setKey(key);
		// testVO.setType(type);

		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		ArrayList<RctBoardVO> rctBoardList = null;
		String paging = null;

		try {
			rctBoardList = rctBoardService.listAllRctBoard(
					Integer.parseInt(tpage), rctSearchVO);
			paging = rctBoardService.pageNumber(Integer.parseInt(tpage),
					rctSearchVO);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("rctBoardList", rctBoardList);
		int n = rctBoardList.size();
		System.out.println(n);
		model.addAttribute("rctBoardListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}

	@RequestMapping("/rctBoardDetail.do")
	public String rctBoardDetail(@RequestParam String rctboard_posting_no,
			HttpSession session, Model model) throws ServletException,
			IOException {
		String url = "rctBoard/rctBoardDetail";
		MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		// ArrayList<QnaBoardCommVO> qnaBoardCommList = new
		// ArrayList<QnaBoardCommVO>();
		RctBoardVO rctBoardVO = rctBoardService
				.getRctDetail(rctboard_posting_no);

		model.addAttribute("rctBoardVO", rctBoardVO);

		return url;
	}

	@RequestMapping(value="/rctBoardSearch.do",method=RequestMethod.POST)
	public String getQnaBoardList(HttpServletRequest request,Model model)
		throws ServletException,IOException{
		String total = "";
		String url = "rctBoard/rctBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type= request.getParameter("type");
		String area = request.getParameter("area");
		String lan = request.getParameter("lan");
		String comg = request.getParameter("comg");
		String grade = request.getParameter("grade");
		String sal = request.getParameter("sal");
		String comp_name = request.getParameter("comp_name");
		String title = request.getParameter("title");
		
		if(area == null){
			area = "";
		}
		if(lan == null){
			lan = "";
		}
		if(comg == null){
			comg = "";
		}
		if(grade == null){
			grade = "";
		}
		if(sal == null){
			sal = "";
		}
		if(comp_name == null){
			comp_name = "";
		}
		if(title == null){
			title = "";
		}		
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
		ArrayList<RctBoardVO> rctBoardList = null;
		String paging = null;
		
//		testVO testVO = new testVO();
		rctSearchVO rctSearchVO = new rctSearchVO(); 
//		ArrayList<QnaBoardBChuVO> qnaBChuList = null;
		
//		testVO.setKey(key);
//		testVO.setType(type);
		
		try {
			total= rctBoardService.getTotal(rctSearchVO)+"";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			rctBoardList = rctBoardService.getRctBoardList(Integer.parseInt(tpage), rctSearchVO);
			paging = rctBoardService.pageNumber(Integer.parseInt(tpage), rctSearchVO);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("rctBoardList", rctBoardList);
		int n = rctBoardList.size();
		model.addAttribute("searchCnt",total);
		model.addAttribute("paging", paging);

		return url;
	}
}
