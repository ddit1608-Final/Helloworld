package com.hello.world.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.world.dto.IsBoardCommVO;
import com.hello.world.service.IfShrBoardService;
import com.hello.world.service.IsBoardCommService;

@Controller
@RequestMapping(value = "/is")
public class IsBoardCommController {

	@Autowired
	IfShrBoardService ifShrBoardService;

	@Autowired
	IsBoardCommService isBoardCommService;

	@RequestMapping(value = "/writeComm", method = RequestMethod.POST)
	public String writeComm(IsBoardCommVO ibcVO, Model model, String mem_nick) {
		String url = "redirect:ifShrBoardDetail.do?ifshrboard_posting_no="
				+ ibcVO.getIfshrboard_posting_no();

		try {
			ibcVO.setIfshrboard_comm_wri(mem_nick);
			isBoardCommService.insertComm(ibcVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping(value = "/deleteIsBoardComm.do")
	public String deleteIsBoardComm(@RequestParam String ifshrboard_ans_code,
			IsBoardCommVO ibcVO, HttpSession session) throws ServletException,
			IOException {
		String url = "redirect:ifShrBoardDetail.do?ifshrboard_posting_no="
				+ ibcVO.getIfshrboard_posting_no();
		isBoardCommService.deleteIsBoardComm(ifshrboard_ans_code);

		return url;
	}

	@RequestMapping(value = "/updateIsBoardCommForm.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String updateIsBoardCommForm(HttpServletRequest request)
			throws ServletException, IOException {

		String ifshrboard_comm_cont = request
				.getParameter("ifshrboard_comm_cont");

		return ifshrboard_comm_cont;

	}
	
	@RequestMapping(value = "/updateIsBoardComm.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String updateIsBoardComm(HttpServletRequest request)
			throws ServletException, IOException {

		String ifshrboard_ans_code = request
				.getParameter("ifshrboard_ans_code");
		
		String ifshrboard_comm_cont = request
				.getParameter("ifshrboard_comm_cont");
		
		IsBoardCommVO isBoardCommVO = new IsBoardCommVO();
		isBoardCommVO.setIfshrboard_comm_cont(ifshrboard_comm_cont.trim());
		isBoardCommVO.setIfshrboard_ans_code(ifshrboard_ans_code);
		isBoardCommService.updateIsBoardComm(isBoardCommVO);

		return ifshrboard_comm_cont;

	}

}
