package com.hello.world.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.IsBoardCommVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.IfShrBoardService;
import com.hello.world.service.IsBoardCommService;

@Controller
@RequestMapping("/is")
public class IfShrBoardController {

	
	@Autowired
	IfShrBoardService ifShrBoardService;
	
	@Autowired
	IsBoardCommService isBoardCommService;
	
	@RequestMapping("/ifShrBoardList.do")
	public String ifShareBoardList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {
		String total="";
		String url = "ifShrBoard/ifShrBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);
		
		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType("ifshrboard_title");
		try {
			total= ifShrBoardService.getTotal(testVO)+"";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		ArrayList<IfShrBoardVO> ifShrBoardList = null;
		String paging = null;

		try {
			ifShrBoardList = ifShrBoardService.getIsBoardList(
					Integer.parseInt(tpage), testVO);
			//System.out.println("테스트입니다 "+ifShrBoardList);
			paging = ifShrBoardService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("ifShrBoardList", ifShrBoardList);
		//int n = ifShrBoardList.size();
		//model.addAttribute("ifShrBoardListSize", n);
		model.addAttribute("paging", paging);
		model.addAttribute("searchCnt",total);
		return url;
	}
	
	@RequestMapping(value="/ifShrBoardWriteForm.do",method=RequestMethod.GET)
	public String ifShrBoardWriteForm(HttpSession session)throws ServletException,IOException{
		String url="ifShrBoard/ifShrBoardWrite";
		
		MemVO loginUser=(MemVO)session.getAttribute("loginUser");
		
		return url;
	}
	
	@RequestMapping(value="/ifShrBoardWrite.do",method=RequestMethod.POST)
	public String ifShrBoardWrite(IfShrBoardVO ifShrBoardVO,HttpSession session) throws ServletException,IOException{
		String url="redirect:ifShrBoardList.do";
		MemVO loginUser = (MemVO)session.getAttribute("loginUser");
		String a =ifShrBoardVO.getIfshrboard_cont().replace("\r\n","<br>");
		ifShrBoardVO.setIfshrboard_cont(a);
		try {
			if(ifShrBoardService.insertIfShrBoard(ifShrBoardVO)==1){
				url+="?result:success";
			}else{
				url+="?result:fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping(value="/ifShrBoardDetail.do",method=RequestMethod.GET)
	public String ifShrBoardDetail(@RequestParam String ifshrboard_posting_no,HttpSession session,Model model
			,HttpServletRequest request)
		throws ServletException,IOException{
			
		String url = "ifShrBoard/ifShrBoardDetail";
		
		ArrayList<IsBoardCommVO> isBoardCommList = new ArrayList<IsBoardCommVO>();
		IfShrBoardVO ifShrBoardVO = ifShrBoardService.getIfShrBoardDetail(ifshrboard_posting_no);
		ifShrBoardService.updateHits(ifShrBoardVO);
		try {
			isBoardCommList = isBoardCommService.listIsBoardComm(ifshrboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("ifShrBoardVO",ifShrBoardVO);
		model.addAttribute("isBoardCommList",isBoardCommList);
		model.addAttribute("isBoardCommListCnt", isBoardCommList.size());
		
		return url;
	}
	
	// 게시글 수정 폼 입장
	@RequestMapping(value="/ifShrBoardUpdateForm.do",method=RequestMethod.GET)
	public String ifShrBoardUpdateForm(@RequestParam String ifshrboard_posting_no,HttpSession session,Model model)
		throws ServletException,IOException{
		String url="ifShrBoard/ifShrBoardUpdate";
		
		IfShrBoardVO ifShrBoardVO = ifShrBoardService.getIfShrBoardDetail(ifshrboard_posting_no);
		String a =ifShrBoardVO.getIfshrboard_cont().replace("<br>","\r\n");
		ifShrBoardVO.setIfshrboard_cont(a);
		model.addAttribute("ifShrBoardVO",ifShrBoardVO);
		
		
		
		return url;
	}
	// 게시글 수정 완료
	@RequestMapping(value="/ifShrBoardUpdate.do",method=RequestMethod.POST)
	public String ifShrBoardUpdate(IfShrBoardVO ifShrBoardVO,HttpSession session)
		throws ServletException,IOException{
		String url = "redirect:ifShrBoardList.do";
		
		MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		ifShrBoardService.updateIfShrBoard(ifShrBoardVO);
		
		return url;
		
	}
	
	@RequestMapping(value="/deleteIfShrBoard.do",method=RequestMethod.GET)
	public String deleteIfShrBoard(@RequestParam String ifshrboard_posting_no,HttpSession session)
		throws ServletException,IOException{
		
		String url = "redirect:ifShrBoardList.do";
		
		ifShrBoardService.deleteIfShrBoard(ifshrboard_posting_no);
		
		return url;
		
	}
	// 검색기능 추가중
	@RequestMapping(value="/ifShrBoardSearch.do",method = RequestMethod.POST)
	public String getIsBoardList(HttpServletRequest request,Model model)
			throws ServletException,IOException{
		String total = "";
		String url = "ifShrBoard/ifShrBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type= request.getParameter("type");
		
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
		ArrayList<IfShrBoardVO> isBoardList = null;
		String paging = null;
		
		testVO testVO = new testVO();
		
		testVO.setKey(key);
		testVO.setType(type);
		
		try {
			total= ifShrBoardService.getTotal(testVO)+"";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			/*isBoardList = ifShrBoardService.getIsBoardList(
					Integer.parseInt(tpage), key);*/
			isBoardList = ifShrBoardService.getIsBoardList(
					Integer.parseInt(tpage), testVO);
			paging = ifShrBoardService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("ifShrBoardList", isBoardList);
		int n = isBoardList.size();
		model.addAttribute("searchCnt",total);
		model.addAttribute("paging", paging);

		return url;
	}
}
