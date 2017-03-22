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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.WebSocketSession;

import com.hello.world.dto.CstBoardCommVO;
import com.hello.world.dto.CstBoardCounselVO;
import com.hello.world.dto.FlowVO;
import com.hello.world.dto.MeetBoardCommVO;
import com.hello.world.dto.MeetBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.PointVO;
import com.hello.world.service.AddressService;
import com.hello.world.service.CompMemberService;
import com.hello.world.service.CrrService;
import com.hello.world.service.CstBoardCommService;
import com.hello.world.service.CstBoardService;
import com.hello.world.service.FlowService;
import com.hello.world.service.LangService;
import com.hello.world.service.MemberService;
import com.hello.world.service.PointService;
import com.hello.world.websocket.EchoHandler;

@Controller
@RequestMapping("admin")
public class AdminController {
	// 관리자 페이지 pwd
	final static String ADMIN_PW = "admin";

	@Autowired
	FlowService flowService;

	@Autowired
	private CompMemberService compMemService;

	@Autowired
	private MemberService memService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private LangService langService;

	@Autowired
	private CrrService crrService;

	@Autowired
	private PointService poingService;

	@Autowired
	private CstBoardService cstBoardService;
	
	@Autowired
	private CstBoardCommService cstBoardCommService;
	
	@Autowired
	EchoHandler sjs;

	@RequestMapping(value = "/memberDetail", method = RequestMethod.GET)
	public String memberDetail(String mem_mail, Model model) {
		MemVO memVO = new MemVO();
		memVO = memService.getMember(mem_mail);

		PointVO pointVO = new PointVO();

		try {
			pointVO = poingService.selectPoint2(mem_mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("memVO", memVO);
		model.addAttribute("point", pointVO);

		return "admin/memberDetail";
	}

	@RequestMapping(value = "/CstBoardDetail", method = RequestMethod.GET)
	public String freeBoardDetail(
			@RequestParam String cstboard_counsel_posting_no, Model model)
			throws ServletException, IOException {
		String url = "admin/cstBoardDetail";
		ArrayList<CstBoardCommVO> cstBoardCommList = new ArrayList<CstBoardCommVO>();

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
		try {
			cstBoardCommList = cstBoardCommService.listCstBoardComm(cstboard_counsel_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("cstBoardCommList",cstBoardCommList);
		model.addAttribute("cstBoardCommListCnt", cstBoardCommList.size());
		model.addAttribute("cstBoardVO", cstBoardVO);
		return url;
	}

	@RequestMapping(value = "/cstManage", method = RequestMethod.GET)
	public String cstManageList(String key, String tpage, Model model) {
		String url = "admin/cstManageList";

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

		ArrayList<FlowVO> flowList = new ArrayList<FlowVO>();

		try {
			flowList = flowService.listFlowVO();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		model.addAttribute("flowList", flowList);

		ArrayList<CstBoardCounselVO> cstList = null;
		String paging = null;

		try {
			cstList = cstBoardService.listCstBoardAdmin(
					Integer.parseInt(tpage), key);
			paging = cstBoardService
					.cstPageNumberAdmin(Integer.parseInt(tpage));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("cstList", cstList);
		int n = cstList.size();
		model.addAttribute("cstListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}

	@RequestMapping(value = "/memberManage", method = RequestMethod.GET)
	public String memberManageList(String key, String tpage, Model model) {
		String url = "admin/memberManageList";

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

		ArrayList<MemVO> memberList = null;
		String paging = null;

		try {
			memberList = memService.getMemberList(Integer.parseInt(tpage), key);
			paging = memService.pageNumber(Integer.parseInt(tpage), key);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("memberList", memberList);
		int n = memberList.size();
		model.addAttribute("memberListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}

	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public String enterAdmin() {
		return "admin/adminEnter";
	}

	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String mainAdmin(String admin_pw) {
		String url = "";
		if (admin_pw.equals(ADMIN_PW))
			url = "admin/adminMain";
		else
			url = "redirect:enter?result=pwMismatch";
		return url;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainAdminGet() {
		String url = "";
		url = "admin/adminMain";
		return url;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/cstStart", method = RequestMethod.POST)
	@ResponseBody
	public String cstStart(String cstboard_counsel_posting_no) {
		String url = "redirect:cstManage";

		try {
			CstBoardCounselVO vo = cstBoardService
					.getCstBoard(cstboard_counsel_posting_no);
			vo.setFlow_code("2");
			cstBoardService.updateCstBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}
	@RequestMapping(value = "/writeComm", method = RequestMethod.POST)
	@ResponseBody
	public CommWriterInfo writeComm(HttpServletRequest request,@RequestBody Map<String,Object> map, Model model) {
		
		Map<String, WebSocketSession> users=sjs.getUsers();
		WebSocketSession wsSession=null;
		String writer="";
		String today="";
		String cstboard_ans_contt=(String)map.get("cstboard_ans_contt");
		String mem_nick =(String)map.get("mem_nick");
		String cstboard_counsel_posting_no=(String) map.get("cstboard_counsel_posting_no");
		CstBoardCommVO mbcVO = new CstBoardCommVO();
		CstBoardCounselVO mbVO = new CstBoardCounselVO();
		CommWriterInfo cwi = new CommWriterInfo();
		System.out.println("댯글입력test>>"+map.toString());
		List<CstBoardCommVO> cstBoardCommList = new ArrayList<CstBoardCommVO>();
		
			try {
				mbcVO.setCstboard_ans_wri(mem_nick);
				mbcVO.setCstboard_ans_cont(cstboard_ans_contt);
				mbcVO.setCstboard_counsel_posting_no(cstboard_counsel_posting_no);
				cstBoardCommService.insertComm(mbcVO);
				mbcVO = cstBoardCommService.getCstBoardComm(cstBoardCommService.getMaxSeq()+"");
				SimpleDateFormat sdfCurrent=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				Timestamp currentTime = mbcVO.getCstboard_ans_wridate();
				today = sdfCurrent.format(currentTime);
				
				mbVO = cstBoardService.getCstBoard(cstboard_counsel_posting_no);
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
	@RequestMapping(value = "/deleteCstBoardComm",method = RequestMethod.POST)
	@ResponseBody
	public String deleteCstBoardComm(HttpServletRequest request) throws ServletException, IOException {
		String cstboard_ans_code = request.getParameter("cstboard_ans_code");
		
		cstBoardCommService.deleteCstBoardComm(cstboard_ans_code);
		System.out.println("삭제하실 답변코드>>> "+cstboard_ans_code+"           이거입니다");
		return cstboard_ans_code;
	}
	
	
	
	

}
