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

import com.hello.world.dto.CstBoardCounselVO;
import com.hello.world.dto.FlowVO;
import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.service.CstBoardService;
import com.hello.world.service.FlowService;

@Controller
@RequestMapping("cst")
public class CstBoardController {

	@Autowired
	CstBoardService cstBoardService;

	@Autowired
	FlowService flowService;

	@RequestMapping(value = "/CstBoardDetail", method = RequestMethod.GET)
	public String freeBoardDetail(
			@RequestParam String cstboard_counsel_posting_no, Model model)
			throws ServletException, IOException {
		String url = "cstBoard/cstBoardDetail";

		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		model.addAttribute("flowList", flowList);

		CstBoardCounselVO cstBoardVO = new CstBoardCounselVO();
		try {
			cstBoardVO = cstBoardService
					.getCstBoard(cstboard_counsel_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("cstBoardVO", cstBoardVO);
		return url;
	}

	@RequestMapping(value = "/cstBoardUpdate", method = RequestMethod.GET)
	public String freeBoardUpdateForm(
			@RequestParam String cstboard_counsel_posting_no, Model model)
			throws ServletException, IOException {
		String url = "cstBoard/cstBoardUpdate";

		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		model.addAttribute("flowList", flowList);

		CstBoardCounselVO cstBoardVO = new CstBoardCounselVO();
		try {
			cstBoardVO = cstBoardService
					.getCstBoard(cstboard_counsel_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("cstBoardVO", cstBoardVO);
		return url;
	}

	@RequestMapping(value = "/cstBoardUpdate", method = RequestMethod.POST)
	public String freeBoardUpdate(CstBoardCounselVO cstBoard, Model model)
			throws ServletException, IOException {
		String url = "redirect:CstBoardDetail?cstboard_counsel_posting_no="
				+ cstBoard.getCstboard_counsel_posting_no();

		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		model.addAttribute("flowList", flowList);

		try {
			cstBoardService.updateCstBoard(cstBoard);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping("/cstBoardList")
	public String freeBoardList(HttpSession session,
			HttpServletRequest request, Model model) {
		String mem_mail = "";
		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		model.addAttribute("flowList", flowList);

		if (session.getAttribute("loginUser") != null)
			mem_mail = ((MemVO) session.getAttribute("loginUser"))
					.getMem_mail();

		String url = "cstBoard/cstBoardList";
		String cstTpage = request.getParameter("cstTpage");

		if (cstTpage == null) {
			cstTpage = "1"; // 현재 페이지 (default 1)
		} else if (cstTpage.equals("")) {
			cstTpage = "1";
		}

		model.addAttribute("cstTpage", cstTpage);

		ArrayList<CstBoardCounselVO> cstBoardList = null;
		String cstPaging = null;

		try {
			cstBoardList = cstBoardService.listCstBoard(mem_mail);
			cstPaging = cstBoardService.cstPageNumber(
					Integer.parseInt(cstTpage), mem_mail);
			// System.out.println("테스트용 컨트롤러");
			// System.out.println(freeBoardList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("cstBoardList", cstBoardList);
		int n = cstBoardList.size();
		model.addAttribute("CstBoardListSize", n);
		model.addAttribute("paging", cstPaging);

		return url;
	}

	@RequestMapping(value = "/cstBoardWrite", method = RequestMethod.GET)
	public String cstBoardWriteForm(HttpSession session, Model model) {

		String url = "cstBoard/cstBoardWrite";

		if (session.getAttribute("loginUser") == null) {
			url = "redirect:cstBoardList";
			// 로그인 하라는 메세지 띄워줄것.
			// jihyun.Park, 2017-02-01
		}

		return url;
	}

	@RequestMapping(value = "/cstBoardWrite", method = RequestMethod.POST)
	public String cstBoardWrite(CstBoardCounselVO cstBoard, Model model) {

		String url = "redirect:cstBoardList";

		try {
			if (cstBoardService.insertCstBoard(cstBoard) == 1) {
				url += "?result:success";
			} else {
				url += "?result:fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

}