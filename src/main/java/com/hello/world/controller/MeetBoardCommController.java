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

import com.hello.world.dto.MeetBoardCommVO;
import com.hello.world.dto.MeetBoardVO;
import com.hello.world.service.MeetBoardCommService;
import com.hello.world.service.MeetBoardService;
import com.hello.world.websocket.EchoHandler;


@Controller
@RequestMapping("/meet")
public class MeetBoardCommController {

	@Autowired
	MeetBoardService meetService;

	@Autowired
	MeetBoardCommService meetBoardCommService;

	@Autowired
	EchoHandler sjs;
	
	@RequestMapping(value="/writeComm",method=RequestMethod.POST)
	@ResponseBody
	public CommWriterInfo writeComm(HttpServletRequest request,@RequestBody Map<String,Object>map,Model model){
		Map<String, WebSocketSession> users=sjs.getUsers();
		
		WebSocketSession wsSession=null;
		String writer="";
		String today="";
		String meet_board_comm_contt=(String)map.get("meet_board_comm_contt");
		String mem_nick =(String)map.get("mem_nick");
		String meet_board_posting_no=(String) map.get("meet_board_posting_no");
		MeetBoardCommVO mbcVO = new MeetBoardCommVO();
		MeetBoardVO mbVO = new MeetBoardVO();
		CommWriterInfo cwi = new CommWriterInfo();
		System.out.println("댯글입력test>>"+map.toString());
		List<MeetBoardCommVO> meetBoardCommList = new ArrayList<MeetBoardCommVO>();
		
			try {
				mbcVO.setMeet_board_comm_wri(mem_nick);
				mbcVO.setMeet_board_comm_cont(meet_board_comm_contt);
				mbcVO.setMeet_board_posting_no(meet_board_posting_no);
				meetBoardCommService.insertComm(mbcVO);
				mbcVO = meetBoardCommService.getMeetBoardComm(meetBoardCommService.getMaxSeq()+"");
				SimpleDateFormat sdfCurrent=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				Timestamp currentTime = mbcVO.getMeet_board_comm_wridate();
				today = sdfCurrent.format(currentTime);
				
				mbVO = meetService.getMeetDetail(meet_board_posting_no);
				writer=mbVO.getMem_mail();
				wsSession = sjs.getUsers().get(writer);
					
				cwi.setMem_mail(writer);
				cwi.setToday(today);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return cwi;
	}
	@RequestMapping(value="/deleteMeetBoardComm.do",method=RequestMethod.POST)
	@ResponseBody
	public String deleteMeetBoardComm(HttpServletRequest request) throws ServletException, IOException{
		String meet_board_ans_code = request.getParameter("meet_board_ans_code");
		meetBoardCommService.deleteMeetBoardComm(meet_board_ans_code);
		System.out.println("삭제할 답변코드>>"+meet_board_ans_code+"   이거다");
		
		return meet_board_ans_code;
	}
	@RequestMapping(value="/updateMeetBoardCommForm.do", method = RequestMethod.POST, produces="application/text; charset=utf-8")
	public String updateMeetBoardCommForm(HttpServletRequest request)throws ServletException, IOException{
		String meet_board_comm_cont = request
				.getParameter("meet_board_comm_cont");
		return meet_board_comm_cont;
	}
	public String updateMeetBoardComm(HttpServletRequest request)throws ServletException,IOException{
		String meet_board_ans_code=request.getParameter("meet_board_ans_code");
		String meet_board_comm_cont = request.getParameter("meet_board_comm_cont");
		
		MeetBoardCommVO meetBoardCommVO = new MeetBoardCommVO();
		meetBoardCommVO.setMeet_board_comm_cont(meet_board_comm_cont.trim());
		meetBoardCommVO.setMeet_board_ans_code(meet_board_ans_code);
		meetBoardCommService.updateMeetBoardComm(meetBoardCommVO);
		
		return meet_board_comm_cont;
	}
	
}
