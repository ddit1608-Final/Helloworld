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
import com.hello.world.dto.SearchVO;
import com.hello.world.dto.rctSearchVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.RctBoardService;
import com.hello.world.service.SearchService;

@Controller
@RequestMapping("/rct")
public class RctBoardController {

	@Autowired
	private RctBoardService rctBoardService;
	
	@Autowired
	private SearchService SearchService;

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
		String url = "redirect:rctBoardList.do";

		// MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		rctBoardService.insertRctBoard(rctBoardVO);

		return url;
	}

	@RequestMapping("/rctBoardList.do")
	public String rctBoardList(HttpSession session, Model model,
			HttpServletRequest request,SearchVO searchVO) throws ServletException, IOException {

		String url = "rctBoard/rctBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type = request.getParameter("type");
		
		int total = 0;
		
		if(searchVO.getRctboard_title() == null){
			searchVO.setRctboard_title("");
		}
		if(searchVO.getRctboard_acdmcr() == null){
			searchVO.setRctboard_acdmcr("");
		}
		if(searchVO.getRctboard_emp_kind() == null){
			searchVO.setRctboard_emp_kind("");
		}
		if(searchVO.getRctboard_work_time() == null){
			searchVO.setRctboard_work_time("");
		}
		if(searchVO.getRctboard_workp() == null){
			searchVO.setRctboard_workp("");
		}
		if(searchVO.getRctboard_year_sal() == null){
			searchVO.setRctboard_year_sal("");
		}
		
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		if (type == null) {
			type = "rctboard_title";
		}

		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);

		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		ArrayList<RctBoardVO> rctBoardList = null;
		String paging = null;

		try {
			total = SearchService.getTotal(searchVO);
			rctBoardList = rctBoardService.listAllRctBoard(
					Integer.parseInt(tpage), searchVO);
			paging = rctBoardService.pageNumber(Integer.parseInt(tpage),
					searchVO);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("rctBoardList", rctBoardList);
		model.addAttribute("paging", paging);

		return url;
	}

	@RequestMapping("/rctBoardDetail.do")
	public String rctBoardDetail(@RequestParam String rctboard_posting_no,
			HttpSession session, Model model) throws ServletException,
			IOException {
		String url = "rctBoard/rctBoardDetail";
		/*MemVO loginUser = (C) session.getAttribute("loginUser");*/

		// ArrayList<QnaBoardCommVO> qnaBoardCommList = new
		// ArrayList<QnaBoardCommVO>();
		RctBoardVO rctBoardVO = rctBoardService
				.getRctDetail(rctboard_posting_no);

		model.addAttribute("rctBoardVO", rctBoardVO);

		return url;
	}

	@RequestMapping(value="/rctBoardSearch.do",method=RequestMethod.GET)
	public String getQnaBoardList(HttpServletRequest request,Model model, SearchVO searchVO)
		throws ServletException,IOException{
		int total = 0;
		String url = "rctBoard/rctBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type= request.getParameter("type");
		
		if(searchVO.getRctboard_title() == null){
			searchVO.setRctboard_title("");
		}
		if(searchVO.getRctboard_acdmcr() == null){
			searchVO.setRctboard_acdmcr("");
		}
		if(searchVO.getRctboard_emp_kind() == null){
			searchVO.setRctboard_emp_kind("");
		}
		if(searchVO.getRctboard_work_time() == null){
			searchVO.setRctboard_work_time("");
		}
		if(searchVO.getRctboard_workp() == null){
			searchVO.setRctboard_workp("");
		}
		if(searchVO.getRctboard_year_sal() == null){
			searchVO.setRctboard_year_sal("");
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
		SearchVO rctSearchVO = new SearchVO(); 
//		ArrayList<QnaBoardBChuVO> qnaBChuList = null;
		
//		testVO.setKey(key);
//		testVO.setType(type);
		
		try {
			total = SearchService.getTotal(searchVO);
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
