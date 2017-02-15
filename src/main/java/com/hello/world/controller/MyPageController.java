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

import com.hello.world.dto.CstBoardCounselVO;
import com.hello.world.dto.FlowVO;
import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.MeetBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.PointVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.CstBoardService;
import com.hello.world.service.FlowService;
import com.hello.world.service.FreeBoardService;
import com.hello.world.service.IfShrBoardService;
import com.hello.world.service.MeetBoardService;
import com.hello.world.service.MemberService;
import com.hello.world.service.PointService;
import com.hello.world.service.QnaBoardService;

@Controller
@RequestMapping("mypage")
public class MyPageController {
	
	@Autowired
	IfShrBoardService ifShrBoardService;
	
	@Autowired
	MeetBoardService meetService;
	
	@Autowired
	QnaBoardService qnaBoardService;

	@Autowired
	FreeBoardService freeService;

	@Autowired
	CstBoardService cstBoardService;

	@Autowired
	FlowService flowService;

	@Autowired
	MemberService memberService;

	@Autowired
	PointService pointService;

	@RequestMapping(value = "/myBoard", method = RequestMethod.GET)
	public String myFreeBoard(HttpSession session, Model model,
			HttpServletRequest request) {
		String url = "";
		String total = "";
		String tpage = request.getParameter("tpage");
		String type = request.getParameter("type");
		String mem_mail = "";

		if (type == "" || type == null) {
			type = "FreeBoard";
		}
		if (session.getAttribute("loginUser") != null)
			mem_mail = ((MemVO) session.getAttribute("loginUser"))
					.getMem_mail();

		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		testVO testVO = new testVO();
		testVO.setKey(mem_mail);
		testVO.setType("mem_mail");

		switch (type) {
		case "FreeBoard":
			ArrayList<FreeBoardVO> freeBoardList = null;
			String freePaging = null;
			try {
				total = freeService.getTotal(testVO) + "";
				freeBoardList = freeService.getFreeBoardList(
						Integer.parseInt(tpage), testVO);
				freePaging = freeService.pageNumber(Integer.parseInt(tpage),
						testVO);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			model.addAttribute("freeBoardList", freeBoardList);
			model.addAttribute("freePaging", freePaging);
			model.addAttribute("total", total);
			url = "myPage/myFreeBoardList";
			break;
		case "QnaBoard":
			ArrayList<QnaBoardVO> qnaBoardList = null;
			String qnaPaging = null;
			try {
				total = qnaBoardService.getTotal(testVO)+"";
				qnaBoardList = qnaBoardService.listAllQnaBoard(
						Integer.parseInt(tpage), testVO);
				qnaPaging = qnaBoardService.pageNumber(Integer.parseInt(tpage),
						testVO);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			model.addAttribute("qnaBoardList", qnaBoardList);
			model.addAttribute("qnaPaging", qnaPaging);
			model.addAttribute("total", total);
			url = "myPage/myQnaBoardList";
			break;
		case "Meet_Board":
			ArrayList<MeetBoardVO> meetBoardList = null;
			String meetPaging = null;
			try {
				total = qnaBoardService.getTotal(testVO)+"";
				meetBoardList = meetService.listAllMeetBoardMyPage(
						Integer.parseInt(tpage), testVO);
				meetPaging = qnaBoardService.pageNumber(Integer.parseInt(tpage),
						testVO);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			model.addAttribute("meetBoardList", meetBoardList);
			model.addAttribute("meetPaging", meetPaging);
			model.addAttribute("total", total);
			url = "myPage/myMeetBoardList";
			break;
		case "IfshrBoard":
			ArrayList<IfShrBoardVO> ifshrBoardList = null;
			String ifshrPaging = null;
			try {
				total = ifShrBoardService.getTotal(testVO)+"";
				ifshrBoardList = ifShrBoardService.getIsBoardList(
						Integer.parseInt(tpage), testVO);
				ifshrPaging = ifShrBoardService.pageNumber(Integer.parseInt(tpage),
						testVO);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			model.addAttribute("ifshrBoardList", ifshrBoardList);
			model.addAttribute("ifshrPaging", ifshrPaging);
			model.addAttribute("total", total);
			url = "myPage/myIfshrBoardList";
			break;

		default:
			break;
		}

		return url;
	}

	@RequestMapping(value = "/CstBoardDetail", method = RequestMethod.GET)
	public String freeBoardDetail(
			@RequestParam String cstboard_counsel_posting_no, Model model)
			throws ServletException, IOException {
		String url = "myPage/cstBoardDetail";

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

	@RequestMapping(value = "/cstBoardUpdate", method = RequestMethod.GET)
	public String freeBoardUpdateForm(
			@RequestParam String cstboard_counsel_posting_no, Model model)
			throws ServletException, IOException {
		String url = "myPage/cstBoardUpdate";

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

		String url = "redirect:cstBoardList";

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

	@RequestMapping("/cstBoardList")
	public String freeBoardList(HttpSession session,
			HttpServletRequest request, Model model) {
		String mem_mail = "";
		String key = request.getParameter("key");
		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		model.addAttribute("flowList", flowList);

		if (session.getAttribute("loginUser") != null)
			mem_mail = ((MemVO) session.getAttribute("loginUser"))
					.getMem_mail();

		String url = "myPage/cstBoardList";
		String tpage = request.getParameter("tpage");

		
		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		model.addAttribute("tpage", tpage);

		ArrayList<CstBoardCounselVO> cstBoardList = null;
		String cstPaging = null;

		try {
			cstBoardList = cstBoardService.listCstBoard(mem_mail, Integer.parseInt(tpage), key);
			cstPaging = cstBoardService.cstPageNumber(
					Integer.parseInt(tpage), mem_mail);
			// System.out.println("테스트용 컨트롤러");
			// System.out.println(freeBoardList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("cstBoardList", cstBoardList);
		int n = cstBoardList.size();
		model.addAttribute("CstBoardListSize", n);
		model.addAttribute("paging", cstPaging);

		return url;
	}

	@RequestMapping(value = "/updateInfo", method = RequestMethod.GET)
	public String updateInfoForm() {
		String url = "myPage/MyInfo";

		return url;
	}

	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public String updateInfo(MemVO memVO, Model model, HttpSession session) {
		String url = "redirect:main";

		try {
			memberService.updateMember(memVO);
			session.setAttribute("loginUser", memVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping(value = "/findZipNum", method = RequestMethod.GET)
	public String findZipNum() {
		String url = "member/findZipNum";

		return url;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String myPageMain(HttpSession session, Model model,
			HttpServletRequest request) {

		if (session.getAttribute("loginUser") == null) {
			return "redirect:/index2.jsp";
		}

		String mem_mail = ((MemVO) session.getAttribute("loginUser"))
				.getMem_mail();
		String tpage = request.getParameter("tpage");

		String url = "myPage/MyPageMain";

		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}

		model.addAttribute("tpage", tpage);

		ArrayList<PointVO> myPointList = new ArrayList<PointVO>();
		String paging = null;

		try {
			myPointList = pointService.listMyPoint(mem_mail,
					Integer.parseInt(tpage));
			paging = pointService.pageNumber(Integer.parseInt(tpage), mem_mail);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("myPointList", myPointList);
		int n = myPointList.size();
		model.addAttribute("myPointListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}
}
