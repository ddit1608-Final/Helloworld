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

import com.hello.world.dto.DogBoardCommVO;
import com.hello.world.dto.DogBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.NoticeVO;
import com.hello.world.dto.PostingTypeVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.DogBoardCommService;
import com.hello.world.service.DogBoardService;
import com.hello.world.service.NoticeService;
import com.hello.world.service.PostingService;

@Controller
@RequestMapping("/dog")
public class DogBoardController {

	
	@Autowired
	DogBoardService dogBoardService;
	
	@Autowired
	DogBoardCommService dogBoardCommService;
	@Autowired
	PostingService postingService;
	
	@Autowired
	NoticeService notiSvc;
	
	@RequestMapping("/dogBoardList")
	public String dsBoardList(HttpSession session, Model model,
			HttpServletRequest request ) throws ServletException, IOException {
		String total="";
		String url = "dogBoard/dogBoardList";
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
		ArrayList<PostingTypeVO> postingList = new ArrayList<PostingTypeVO>();
		
		try {
			postingList =postingService.listPostingVO();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		model.addAttribute("postingList",postingList);
		ArrayList<PostingTypeVO> typeList = new ArrayList<PostingTypeVO>();
		try {
			typeList=postingService.listPostingVO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		model.addAttribute("typeList",typeList);
		
		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);
		
		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType("dsboard_title");
		
			try {
				total= dogBoardService.getTotal(testVO)+"";
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		ArrayList<DogBoardVO> dogBoardList = null;
		String paging = null;
		try {
			dogBoardList = dogBoardService.getDsBoardList(
					Integer.parseInt(tpage), testVO);
			//System.out.println("테스트입니다 "+dsboardList);
			paging = dogBoardService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<NoticeVO> notiList = new ArrayList<NoticeVO>();
		
		try {
			notiList=notiSvc.listAllNotice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// modal 창에 바로 뛰어버리자 귀찮다
		String notice_id = request.getParameter("notice_id");
		NoticeVO noticeVO = notiSvc.getNoticeDetail(notice_id);

		model.addAttribute("noticeVO", noticeVO);
		model.addAttribute("notiList",notiList);
		

		model.addAttribute("dogBoardList", dogBoardList);
		model.addAttribute("paging", paging);
		model.addAttribute("searchCnt",total);
		return url;
	}
	
	@RequestMapping(value="/dogBoardWrite",method=RequestMethod.GET)
	public String dsBoardWriteForm(HttpSession session,Model model)throws ServletException,IOException{
		String url="dogBoard/dogBoardWrite";
		
		MemVO loginUser=(MemVO)session.getAttribute("loginUser");
		ArrayList<PostingTypeVO> typeList = new ArrayList<PostingTypeVO>();
		try {
			typeList=postingService.listPostingVO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("typeList",typeList);
		
		return url;
	}
	
	@RequestMapping(value="/dogBoardWrite",method=RequestMethod.POST)
	public String dsBoardWrite(DogBoardVO dogboardVO,HttpSession session) throws ServletException,IOException{
		String url="redirect:dogBoardList";
		MemVO loginUser = (MemVO)session.getAttribute("loginUser");
		String a =dogboardVO.getDsboard_cont().replace("\r\n","<br>");
		dogboardVO.setDsboard_cont(a);
		/*String b =dogboardVO.getDsboard_cont().replace("<","&lt;");
		String c =dogboardVO.getDsboard_cont().replace(">","&gt;");
		dogboardVO.setDsboard_cont(a+b+c);*/
		try {
			if(dogBoardService.insertDsBoard(dogboardVO)==1){
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
	
	@RequestMapping(value="/dogBoardDetail",method=RequestMethod.GET)
	public String dsBoardDetail(@RequestParam String dsboard_posting_no,HttpSession session,Model model,HttpServletRequest request)
		throws ServletException,IOException{
			
		String url = "dogBoard/dogBoardDetail";
		
		ArrayList<DogBoardCommVO> dogBoardCommList = new ArrayList<DogBoardCommVO>();
		DogBoardVO dogBoardVO = dogBoardService.getDsBoardDetail(dsboard_posting_no);
		dogBoardService.updateHits(dogBoardVO);
		ArrayList<PostingTypeVO> typeList = new ArrayList<PostingTypeVO>();
		try {
			typeList=postingService.listPostingVO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		model.addAttribute("typeList",typeList);
		try {
			dogBoardCommList = dogBoardCommService.listDsBoardComm(dsboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("dogBoardVO",dogBoardVO);
		model.addAttribute("dogBoardCommList",dogBoardCommList);
		model.addAttribute("dogBoardCommListCnt", dogBoardCommList.size());
		
		return url;
	}
	
	// 게시글 수정 폼 입장
	@RequestMapping(value="/dogBoardUpdate",method=RequestMethod.GET)
	public String dsBoardUpdateForm(@RequestParam String dsboard_posting_no,HttpSession session,Model model)
		throws ServletException,IOException{
		String url="dogBoard/dogBoardUpdate";
		
		DogBoardVO dogBoardVO = dogBoardService.getDsBoardDetail(dsboard_posting_no);
		String a =dogBoardVO.getDsboard_cont().replace("<br>","\r\n");
		dogBoardVO.setDsboard_cont(a);
		/*String b =dogBoardVO.getDsboard_cont().replace("&lt;","<");
		String c =dogBoardVO.getDsboard_cont().replace("&gt;",">");
		dogBoardVO.setDsboard_cont(a+b+c);*/
		model.addAttribute("dogBoardVO",dogBoardVO);
		
		
		
		return url;
	}
	// 게시글 수정 완료
	@RequestMapping(value="/dogBoardUpdate",method=RequestMethod.POST)
	public String dsBoardUpdate(DogBoardVO dogBoardVO,HttpSession session)
		throws ServletException,IOException{
		String url = "redirect:dogBoardList";
		
		MemVO loginUser = (MemVO) session.getAttribute("loginUser");
		String a =dogBoardVO.getDsboard_cont().replace("\r\n","<br>");
		dogBoardVO.setDsboard_cont(a);
		dogBoardService.updateDsBoard(dogBoardVO);
		
		return url;
		
	}
	
	@RequestMapping(value="/deleteDogBoard",method=RequestMethod.GET)
	public String deleteDsBoard(@RequestParam String dsboard_posting_no,HttpSession session)
		throws ServletException,IOException{
		
		String url = "redirect:dogBoardList";
		
		dogBoardService.deleteDsBoard(dsboard_posting_no);
		
		return url;
		
	}
	// 검색기능 추가중
	@RequestMapping(value="/dogBoardSearch",method = RequestMethod.POST)
	public String getDsBoardList(HttpServletRequest request,Model model)
			throws ServletException,IOException{
		String total = "";
		// redirect 해야함 안그러면 posting sort select 날라감
		String url = "redirect:dogBoardList";
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
		ArrayList<DogBoardVO> dogBoardList = null;
		String paging = null;
		
		testVO testVO = new testVO();
		
		testVO.setKey(key);
		testVO.setType(type);
		
		try {
			total= dogBoardService.getTotal(testVO)+"";
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			dogBoardList = dogBoardService.getDsBoardList(
					Integer.parseInt(tpage), testVO);
			paging = dogBoardService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("dogBoardList", dogBoardList);
		int n = dogBoardList.size();
		model.addAttribute("searchCnt",total);
		model.addAttribute("paging", paging);

		return url;
	}
	
	
	// sort!!!!!!!!!
	@RequestMapping(value="/typeDoggy",method=RequestMethod.GET)
	public String typeDoggy(HttpServletRequest request, Model model,PostingTypeVO typeVO)throws IOException,ServletException{
		String total = "";
		
		String url="dogBoard/dogBoardList";
		String tpage = request.getParameter("tpage");
		
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		
		ArrayList<PostingTypeVO> typeList = new ArrayList<PostingTypeVO>();
		try {
			typeList=postingService.listPostingVO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		model.addAttribute("typeList",typeList);
		
		model.addAttribute("tpage", tpage);
		ArrayList<DogBoardVO> dogBoardList = null;
		String paging = null;
		
		
		try {
			total= dogBoardService.getTotall(typeVO)+"";
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			dogBoardList = dogBoardService.getDogList(Integer.parseInt(tpage), typeVO);
			paging = dogBoardService.pageNumberr(Integer.parseInt(tpage), typeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("dogBoardList", dogBoardList);
		//int n = dogBoardList.size();
		model.addAttribute("searchCnt",total);
		model.addAttribute("paging", paging);

		return url;
		
	}
	
	
	
		
	}
	
	
	
