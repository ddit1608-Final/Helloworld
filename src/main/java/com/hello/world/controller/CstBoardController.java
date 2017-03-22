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

import com.hello.world.dto.CstBoardCommVO;
import com.hello.world.dto.CstBoardCounselVO;
import com.hello.world.dto.FlowVO;
import com.hello.world.service.CstBoardCommService;
import com.hello.world.service.CstBoardService;
import com.hello.world.service.FlowService;

@Controller
@RequestMapping("cst")
public class CstBoardController {

	@Autowired
	CstBoardService cstBoardService;

	@Autowired
	FlowService flowService;
	
	@Autowired
	CstBoardCommService cstBoardCommService;
	
	@RequestMapping("/cstBoardList")
	public String freeBoardList(HttpSession session,
			HttpServletRequest request, Model model) {

		String url = "cstBoard/cstBoardList";

		return url;
	}

	@RequestMapping(value = "/CstBoardDetail", method = RequestMethod.GET)
	public String cstBoardDetail(
			@RequestParam String cstboard_counsel_posting_no, Model model)
			throws ServletException, IOException {
		String url = "cstBoard/cstBoardDetail";
		ArrayList<CstBoardCommVO> cstBoardCommList = new ArrayList<CstBoardCommVO>();
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
		
		try {
			cstBoardCommList = cstBoardCommService.listCstBoardComm(cstboard_counsel_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("cstBoardCommList",cstBoardCommList);
		model.addAttribute("cstBoardCommListCnt", cstBoardCommList.size());
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

		String url = "redirect:/mypage/cstBoardList";

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
