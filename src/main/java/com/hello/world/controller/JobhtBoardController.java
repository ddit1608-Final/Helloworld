package com.hello.world.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hello.world.dto.JobhtBoardVO;
import com.hello.world.service.JobhtBoardService;

@Controller
@RequestMapping("/jobht")
public class JobhtBoardController {

	@Autowired
	JobhtBoardService jobhtBoardService;

	public void setJobhtBoardService(JobhtBoardService jobhtBoardService) {
		this.jobhtBoardService = jobhtBoardService;
	}

	@RequestMapping("/jobhtForm.do")
	public String ResmWriteForm(HttpSession session) throws ServletException,
			IOException {
		String url = "jobhtBoard/jobBoardWrite";

		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		return url;
	}

	@RequestMapping("/jobhtWrite.do")
	public String ResmWriteForm(JobhtBoardVO jobhtBoardVO, HttpSession session)
			throws ServletException, IOException {
		String url = "/index2";

		// MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		System.out.println(jobhtBoardVO);

		jobhtBoardService.insertJobthBoard(jobhtBoardVO);

		return url;
	}
	
	@RequestMapping("/jobhtBoardList.do")
	public String jobhtBoardList(HttpSession session, Model model,
			HttpServletRequest request)
			throws ServletException, IOException {

		String url = "jobhtBoard/jobBoardList";
		String key=request.getParameter("key");
	    String tpage=request.getParameter("tpage");

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		model.addAttribute("key",key);
		model.addAttribute("tpage",tpage);

		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		ArrayList<JobhtBoardVO> jobhtBoardList = null;
		String paging=null;
		
		try {
			jobhtBoardList = jobhtBoardService.listAllJobhtBoard(Integer.parseInt(tpage), key);
			
			paging = jobhtBoardService.pageNumber(Integer.parseInt(tpage), key);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("JobhtBoardList", jobhtBoardList);
		int n=jobhtBoardList.size();   
		model.addAttribute("jobhtBoardListSize", n);
		model.addAttribute("paging", paging);   

		return url;
	}

}
