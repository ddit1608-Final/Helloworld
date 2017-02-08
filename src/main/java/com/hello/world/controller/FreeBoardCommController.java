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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.WebSocketSession;

import com.hello.world.dto.FreeBoardCommVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.IsBoardCommVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.FreeBoardCommService;
import com.hello.world.service.FreeBoardService;
import com.hello.world.service.MemberService;
import com.hello.world.websocket.EchoHandler;

//import com.nonage.dto.MemVO;

@Controller
@RequestMapping("/free")
public class FreeBoardCommController {


	@Autowired
	FreeBoardService freeService;

	@Autowired
	FreeBoardCommService freeBoardCommService;
	@Autowired
	EchoHandler sjs;

	@RequestMapping(value = "/writeComm", method = RequestMethod.POST)
	@ResponseBody
	public String writeComm(HttpServletRequest request,@RequestBody Map<String,Object>map,Model model) {
		Map<String, WebSocketSession> users = sjs.getUsers();
		
		
		String today = "";
		String freeboard_comm_contt = (String) map.get("freeboard_comm_contt");
		String mem_nick = (String) map.get("mem_nick");
		String freeboard_posting_no = (String) map.get("freeboard_posting_no"); 
		FreeBoardCommVO fbcVO = new FreeBoardCommVO();
		System.out.println("댓글 입력test>>"+map.toString());
		//String aa = request.getParameter("ifshrboard_ans_code");
		List<FreeBoardCommVO> freeBoardCommList = new ArrayList<FreeBoardCommVO>();
		try {
			fbcVO.setFreeboard_comm_wri(mem_nick);
			fbcVO.setFreeboard_comm_cont(freeboard_comm_contt);
			fbcVO.setFreeboard_posting_no(freeboard_posting_no);
			freeBoardCommService.insertComm(fbcVO);
			fbcVO = freeBoardCommService.getFreeBoardComm(freeBoardCommService.getMaxSeq()+"");
			
			SimpleDateFormat sdfCurrent = new SimpleDateFormat ("yyyy-mm-dd hh:mm:ss"); 
			Timestamp currentTime = fbcVO.getFreeboard_comm_wridate(); 
			today = sdfCurrent.format(currentTime); 
			
			//isBoardCommList = isBoardCommService.listIsBoardComm(ifshrboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return today;
	}
	@RequestMapping(value = "/deleteFreeBoardComm.do")
	public String deleteFreeBoardComm(@RequestParam String freeboard_ans_code,FreeBoardCommVO fbcVO,
			HttpSession session) throws ServletException, IOException {
		String url = "redirect:freeBoardDetail.do?freeboard_posting_no="
				+ fbcVO.getFreeboard_posting_no();
		freeBoardCommService.deleteFreeBoardComm(freeboard_ans_code);

		return url;
	}
	
	
	// 수정 구현중
	@RequestMapping(value="/updateFreeBoardCommForm.do")
	public String updateFreeBoardComm(
			@RequestParam String freeboard_ans_code,FreeBoardCommVO freeBoardCommVO, HttpSession session,
			Model model, String commCont) throws ServletException, IOException {
		
		System.out.println("test"+freeBoardCommVO.getFreeboard_posting_no());
		freeBoardCommVO.setFreeboard_comm_cont(commCont);
		String url = "redirect:freeBoardDetail.do?freeboard_posting_no="
				+ freeBoardCommVO.getFreeboard_posting_no();
		freeBoardCommService.updateFreeBoardComm(freeBoardCommVO);
		
		return url;
	}
	
	
}