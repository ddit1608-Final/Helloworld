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

import com.hello.world.dto.NoticeVO;
import com.hello.world.service.NoticeService;


@Controller
public class NoticeController {
	@Autowired
	NoticeService notiSvc;
	// 코딩~테스트까지는 이곳에서 적용은 각 게시판으로!
	public ArrayList<NoticeVO> noticeAll(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {
		
		ArrayList<NoticeVO> notiList = new ArrayList<NoticeVO>();
		
		try {
			notiList=notiSvc.listAllNotice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(notiList);
		return notiList;
	}
	public String noticeDetail(@RequestParam String notice_id,
			HttpSession session, Model model) throws ServletException,
			IOException {
		//String url = "freeBoard/freeBoardDetail";
		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		//ArrayList<FreeBoardCommVO> freeBoardCommList = new ArrayList<FreeBoardCommVO>();
		NoticeVO noticeVO = notiSvc.getNoticeDetail(notice_id);
		// notiSvc.updateNotiHits(noticeVO);

		model.addAttribute("noticeVO", noticeVO);
		//model.addAttribute("freeBoardCommList", freeBoardCommList);
		//model.addAttribute("freeBoardCommListCnt", freeBoardCommList.size());
		return null;
	}
	@RequestMapping(value="/noticeUpdate",method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String updateNotice(HttpServletRequest req)throws ServletException,IOException{
		String notice_id = req.getParameter("notice_id");
		System.out.println("zzzzzzzzzzzzzzzzzzzzz>>>>"+notice_id);
		String notice_cont = req.getParameter("notice_cont");
		NoticeVO notiVO = new NoticeVO();
		notiVO.setNotice_cont(notice_cont.trim());
		notiVO.setNotice_id(notice_id);
		notiSvc.updateNotice(notiVO);
		
		return notice_cont;
		
	}
	
	
	
	
}
