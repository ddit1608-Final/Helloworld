package com.hello.world.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.socket.WebSocketSession;

import com.hello.world.dto.DogBoardCommVO;
import com.hello.world.dto.IsBoardCommVO;
import com.hello.world.service.DogBoardCommService;
import com.hello.world.service.DogBoardService;
import com.hello.world.websocket.EchoHandler;

@Controller
@RequestMapping(value = "/dog")
public class DogBoardCommController {

	@Autowired
	DogBoardService dogBoardService;

	@Autowired
	DogBoardCommService dogBoardCommService;
	
	@Autowired
	EchoHandler sjs;

	@RequestMapping(value = "/writeComm", method = RequestMethod.POST)
	@ResponseBody
	public String writeComm(HttpServletRequest request,@RequestBody Map<String,Object> map, Model model) {
		/*String url = "redirect:ifShrBoardDetail.do?ifshrboard_posting_no="
				+ ibcVO.getIfshrboard_posting_no();*/
		
		Map<String, WebSocketSession> users = sjs.getUsers();
		
		
		String today = "";
		String dsboard_comm_contt = (String) map.get("dsboard_comm_contt");
		String mem_nick = (String) map.get("mem_nick");
		String dsboard_posting_no = (String) map.get("dsboard_posting_no"); 
		DogBoardCommVO dogVO = new DogBoardCommVO();
		List<DogBoardCommVO> dogBoardCommList = new ArrayList<DogBoardCommVO>();
		try {
			dogVO.setDsboard_comm_wri(mem_nick);
			dogVO.setDsboard_comm_cont(dsboard_comm_contt);
			dogVO.setDsboard_posting_no(dsboard_posting_no);
			dogBoardCommService.insertComm(dogVO);
			dogVO = dogBoardCommService.getDsBoardComm(dogBoardCommService.getMaxSeq()+"");
			
			SimpleDateFormat sdfCurrent = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss"); 
			Timestamp currentTime = dogVO.getDsboard_comm_wridate(); 
			today = sdfCurrent.format(currentTime); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return today;
	}
	
	@RequestMapping(value = "/deleteDogBoardComm",method = RequestMethod.POST)
	@ResponseBody
	public String deleteDsBoardComm(HttpServletRequest request) throws ServletException, IOException {
		String dsboard_ans_code = request.getParameter("dsboard_ans_code");
		dogBoardCommService.deleteDsBoardComm(dsboard_ans_code);
		System.out.println("삭제하실 답변코드>>> "+dsboard_ans_code+"           이거입니다");
		return dsboard_ans_code;
	}

	@RequestMapping(value = "/updateDogBoardCommForm", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String updateIsBoardCommForm(HttpServletRequest request)
			throws ServletException, IOException {

		String dsboard_comm_cont = request
				.getParameter("dsboard_comm_cont");

		return dsboard_comm_cont;

	}
	
	@RequestMapping(value = "/updateDogBoardComm", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String updateDogBoardComm(HttpServletRequest request)
			throws ServletException, IOException {

		String dsboard_ans_code = request
				.getParameter("ifshrboard_ans_code");
		
		String dsboard_comm_cont = request
				.getParameter("dsboard_ans_cont");
		
		DogBoardCommVO dogBoardCommVO = new DogBoardCommVO();
		dogBoardCommVO.setDsboard_comm_cont(dsboard_comm_cont.trim());
		dogBoardCommVO.setDsboard_ans_code(dsboard_ans_code);
		dogBoardCommService.updateDsBoardComm(dogBoardCommVO);

		return dsboard_comm_cont;

	}
	
	
	

}
