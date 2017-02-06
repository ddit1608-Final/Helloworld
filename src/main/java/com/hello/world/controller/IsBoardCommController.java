package com.hello.world.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.world.dto.IfShrBoardVO;
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
	@ResponseBody
	public List<IsBoardCommVO> writeComm(HttpServletRequest request,@RequestBody Map<String,Object> map, Model model) {
		/*String url = "redirect:ifShrBoardDetail.do?ifshrboard_posting_no="
				+ ibcVO.getIfshrboard_posting_no();*/
		String ifshrboard_comm_contt = (String) map.get("ifshrboard_comm_contt");
		String mem_nick = (String) map.get("mem_nick");
		String ifshrboard_posting_no = (String) map.get("ifshrboard_posting_no"); 
		IsBoardCommVO ibcVO = new IsBoardCommVO();
		System.out.println("댓글 입력test>>"+map.toString());
		//String aa = request.getParameter("ifshrboard_ans_code");
		List<IsBoardCommVO> isBoardCommList = new ArrayList<IsBoardCommVO>();
		try {
			ibcVO.setIfshrboard_comm_wri(mem_nick);
			ibcVO.setIfshrboard_comm_cont(ifshrboard_comm_contt);
			ibcVO.setIfshrboard_posting_no(ifshrboard_posting_no);
			isBoardCommService.insertComm(ibcVO);
			//ibcVO = isBoardCommService.getIsBoardComm(aa);
			isBoardCommList = isBoardCommService.listIsBoardComm(ifshrboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isBoardCommList;
	}
	
	@RequestMapping(value = "/deleteIsBoardComm.do",method = RequestMethod.POST)
	@ResponseBody
	public String deleteIsBoardComm(HttpServletRequest request) throws ServletException, IOException {
		String ifshrboard_ans_code = request.getParameter("ifshrboard_ans_code");
		isBoardCommService.deleteIsBoardComm(ifshrboard_ans_code);
		System.out.println("삭제하실 답변코드>>> "+ifshrboard_ans_code+"           이거입니다");
		return ifshrboard_ans_code;
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
