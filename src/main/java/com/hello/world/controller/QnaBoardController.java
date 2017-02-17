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

import com.hello.world.dto.MemVO;
import com.hello.world.dto.QnaBoardBChuVO;
import com.hello.world.dto.QnaBoardCheckChuVO;
import com.hello.world.dto.QnaBoardChooseVO;
import com.hello.world.dto.QnaBoardChuVO;
import com.hello.world.dto.QnaBoardCommVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.dto.QnaboardBCheckChuVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.QnaBoardBChuService;
import com.hello.world.service.QnaBoardChooseService;
import com.hello.world.service.QnaBoardChuService;
import com.hello.world.service.QnaBoardCommService;
import com.hello.world.service.QnaBoardService;


@Controller
@RequestMapping("/qna")
public class QnaBoardController {
	
	@Autowired
	QnaBoardService qnaBoardService;
	
	@Autowired
	QnaBoardCommService qnaBoardCommService;
	
	@Autowired
	QnaBoardChuService qnaBoardChuService;
	
	@Autowired
	QnaBoardChooseService qnaBoardChooseService;
	
	@Autowired
	QnaBoardBChuService qnaBoardBChuService;
	
	
	@RequestMapping("/qnaBoardWriteForm.do")
	public String freeBoardWriteForm(HttpSession session)
			throws ServletException, IOException {
		String url = "qnaBoard/qnaBoardWrite";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");

		return url;
	}
	
	@RequestMapping("/qnaBoardWrite.do")
	public String freeBoardWrite(QnaBoardVO qnaBoardVO, HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:qnaBoardList.do";

		MemVO loginUser = (MemVO) session.getAttribute("loginUser");
		
		
		System.out.println(qnaBoardVO);
		qnaBoardService.insertQnaBoard(qnaBoardVO);

		return url;
	}
	
	@RequestMapping("/qnaBoardList.do")
	public String freeBoardList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {

		String url = "qnaBoard/qnaBoardList";
		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		String type = request.getParameter("type");

		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		if(type == null) {
			type = "qnaboard_title";
		}

		model.addAttribute("key", key);
		model.addAttribute("tpage", tpage);
		
		testVO testVO = new testVO();
		testVO.setKey(key);
		testVO.setType(type);

		/* MemVO loginUser = (MemVO) session.getAttribute("loginUser"); */

		ArrayList<QnaBoardVO> qnaBoardList = null;
		ArrayList<QnaBoardBChuVO> qnaBChuList = null;
		String paging = null;
		
		

		try {
			qnaBoardList = qnaBoardService.listAllQnaBoard(
					Integer.parseInt(tpage), testVO);
			qnaBChuList = qnaBoardBChuService.listAllQnaBoardBChu();
			paging = qnaBoardService.pageNumber(Integer.parseInt(tpage), testVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("qnaBoardList", qnaBoardList);
		model.addAttribute("qnaBChuList", qnaBChuList);
		int n = qnaBoardList.size();
		model.addAttribute("qnaBoardListSize", n);
		model.addAttribute("paging", paging);

		return url;
	}
	
	@RequestMapping("/qnaBoardDetail.do")
	public String qnaBoardDetail(@RequestParam String qnaboard_posting_no,
			HttpSession session, Model model) throws ServletException,
			IOException {
		String url = "qnaBoard/qnaBoardDetail";
		 MemVO loginUser = (MemVO) session.getAttribute("loginUser"); 

		ArrayList<QnaBoardCommVO> qnaBoardCommList = new ArrayList<QnaBoardCommVO>();
		QnaBoardVO qnaBoardVO = qnaBoardService.getQnaDetail(qnaboard_posting_no);
		qnaBoardService.updateQnaHits(qnaBoardVO);
		
		ArrayList<QnaBoardChuVO> qnaBoardChuList = new ArrayList<QnaBoardChuVO>(); 
		QnaBoardBChuVO qnaBoardBChuList = new QnaBoardBChuVO();
		
		String qnaboard_ans_code = "";
		try {
			qnaBoardCommList = qnaBoardCommService.listQnaBoardComm(qnaboard_posting_no);
			qnaBoardBChuList = qnaBoardBChuService.listQnaBoardBChu(qnaboard_posting_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		QnaBoardChooseVO qnaBoardChooseList = null;
		
		for(QnaBoardCommVO vo:qnaBoardCommList) {
			qnaboard_ans_code = vo.getQnaboard_ans_code();
			try {
				qnaBoardChuList.add(qnaBoardChuService.listQnaBoardChu(qnaboard_ans_code));
				qnaBoardChooseList = qnaBoardChooseService.listQnaBoardChu(qnaboard_ans_code);
				if(qnaBoardChooseService.listQnaBoardChu(qnaboard_ans_code) != null)
					model.addAttribute("qnaBoardChooseList", qnaBoardChooseList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

		model.addAttribute("qnaBoardVO", qnaBoardVO);
		model.addAttribute("qnaBoardCommList", qnaBoardCommList);
		model.addAttribute("qnaBoardCommListCnt", qnaBoardCommList.size());
		model.addAttribute("qnaBoardChuList", qnaBoardChuList);
		model.addAttribute("qnaBoardBChuList", qnaBoardBChuList);
		
		return url;
	}
	
	@RequestMapping(value = "/writeComm", method = RequestMethod.POST)
	public String writeComm(QnaBoardCommVO qncVO, Model model, String mem_mail, 
			QnaBoardChuVO qbcVO, String qnaboard_ans_code) {
		String url = "redirect:qnaBoardDetail.do?qnaboard_posting_no="
				+ qncVO.getQnaboard_posting_no();

		try {
			qncVO.setQnaboard_comm_wri(mem_mail);
			qnaBoardCommService.insertComm(qncVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}
	@RequestMapping(value = "/deleteqnaBoardComm.do")
	public String deleteQnaBoardComm(@RequestParam String qnaboard_ans_code,QnaBoardCommVO qncVO,
			HttpSession session) throws ServletException, IOException {
		String url = "redirect:qnaBoardDetail.do?qnaboard_posting_no="
				+ qncVO.getQnaboard_posting_no();
		qnaBoardCommService.deleteFreeBoardComm(qnaboard_ans_code);

		return url;
	}
	
	@RequestMapping(value = "/chu", method = RequestMethod.POST)
	@ResponseBody
	public String boardChu(@RequestParam String qnaboard_ans_code, QnaBoardChuVO qnaBoardChuVO, QnaBoardCheckChuVO qnaBoardCheckChuVO,
			Model model, HttpServletRequest request){
		
		String chu = request.getParameter("chu");
		
		String mem_mail = request.getParameter("mem_mail");
		
		qnaBoardChuVO.setQnaboard_chu(chu);
		
		qnaBoardChuVO.setQnaboard_ans_code(qnaboard_ans_code);
		
		qnaBoardCheckChuVO.setMem_mail(mem_mail);
		
		qnaBoardCheckChuVO.setQnaboard_ans_code(qnaboard_ans_code);
		
		
		String upChu = chu;
		try {
			if(qnaBoardChuService.countChu(qnaBoardCheckChuVO) == 0) {
				qnaBoardChuService.insertCheckChu(qnaBoardCheckChuVO);
				qnaBoardChuService.updateQnaBoardChuComm(qnaBoardChuVO);
				upChu = qnaBoardChuService.listQnaBoardChu(qnaboard_ans_code).getQnaboard_chu();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return upChu;
	}
	
	@RequestMapping(value = "/bchu", method = RequestMethod.POST)
	@ResponseBody
	public String boardBChu(@RequestParam String qnaboard_ans_code, QnaBoardChuVO qnaBoardChuVO, QnaBoardCheckChuVO qnaBoardCheckChuVO, 
			Model model, HttpServletRequest request){
		
		String bchu = request.getParameter("bchu");
		
		String mem_mail = request.getParameter("mem_mail");
		
		qnaBoardChuVO.setQnaboard_bchu(bchu);
		
		qnaBoardChuVO.setQnaboard_ans_code(qnaboard_ans_code);
		
		qnaBoardCheckChuVO.setMem_mail(mem_mail);
		
		qnaBoardCheckChuVO.setQnaboard_ans_code(qnaboard_ans_code);
		
		
		
		String upBChu = bchu;
		try {
			if(qnaBoardChuService.countChu(qnaBoardCheckChuVO) == 0){
			qnaBoardChuService.insertCheckBChu(qnaBoardCheckChuVO);
			qnaBoardChuService.updateQnaBoardBChuComm(qnaBoardChuVO);
			upBChu = qnaBoardChuService.listQnaBoardChu(qnaboard_ans_code).getQnaboard_bchu();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return upBChu;
	}
	
	@RequestMapping(value="/choose", method=RequestMethod.POST, produces="application/text;charset=utf8")
	@ResponseBody
	public String boardChoose(@RequestParam String qnaboard_ans_code, QnaBoardChooseVO qnaBoardChooseVO, Model model, HttpServletRequest request){
		
		String choose = request.getParameter("choose");
		
		if(choose != null){
			qnaBoardChooseVO.setQnaboard_comm_choose("1");
		}
		
		qnaBoardChooseVO.setQnaboard_ans_code(qnaboard_ans_code);
		
		try {
			qnaBoardChooseService.insertQnaBoardChoose(qnaBoardChooseVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String qnaboardChoose = "";
		
		try {
			if(qnaBoardChooseService.listQnaBoardChu(qnaboard_ans_code).getQnaboard_comm_choose() != null){
				qnaboardChoose = qnaBoardChooseService.listQnaBoardChu(qnaboard_ans_code).getQnaboard_comm_choose();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return qnaboardChoose;
	}
	
	@RequestMapping(value = "/boardchu", method = RequestMethod.POST)
	@ResponseBody
	public String qnaboardChu(@RequestParam String qnaboard_posting_no, QnaBoardBChuVO qnaBoardBChuVO, QnaboardBCheckChuVO qnaboardBCheckChuVO,
			Model model, HttpServletRequest request){
		
		String boardchu = request.getParameter("boardchu");
		String mem_mail = request.getParameter("mem_mail");
		
		qnaBoardBChuVO.setQnaboard_board_chu(boardchu);
		
		qnaBoardBChuVO.setQnaboard_posting_no(qnaboard_posting_no);
		
		qnaboardBCheckChuVO.setMem_mail(mem_mail);
		
		qnaboardBCheckChuVO.setQnaboard_posting_no(qnaboard_posting_no);
		
		
		String upChu =boardchu;
		try {
			if(qnaBoardBChuService.countBChu(qnaboardBCheckChuVO) == 0){
			qnaBoardBChuService.insertBCheckChu(qnaboardBCheckChuVO);
			qnaBoardBChuService.updateQnaBoardBChu(qnaBoardBChuVO);		
			upChu = qnaBoardBChuService.listQnaBoardBChu(qnaboard_posting_no).getQnaboard_board_chu();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return upChu;
	}
	
	@RequestMapping(value = "/boardbchu", method = RequestMethod.POST)
	@ResponseBody
	public String qnaboardBChu(@RequestParam String qnaboard_posting_no, QnaBoardBChuVO qnaBoardBChuVO, QnaboardBCheckChuVO qnaboardBCheckChuVO,
			Model model, HttpServletRequest request){
		
		String boardbchu = request.getParameter("boardbchu");
		
		String mem_mail = request.getParameter("mem_mail");
		
		qnaBoardBChuVO.setQnaboard_board_bchu(boardbchu);
		
		qnaBoardBChuVO.setQnaboard_posting_no(qnaboard_posting_no);
		
		qnaboardBCheckChuVO.setMem_mail(mem_mail);
		
		qnaboardBCheckChuVO.setQnaboard_posting_no(qnaboard_posting_no);
		
		
		
		String upBChu = boardbchu;
		try {
			if(qnaBoardBChuService.countBChu(qnaboardBCheckChuVO) == 0){
			qnaBoardBChuService.insertBCheckChu(qnaboardBCheckChuVO);
			qnaBoardBChuService.updateQnaBoardBBChu(qnaBoardBChuVO);
			upBChu = qnaBoardBChuService.listQnaBoardBChu(qnaboard_posting_no).getQnaboard_board_bchu();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return upBChu;
	}
	
	@RequestMapping(value="/qnaBoardSearch.do",method=RequestMethod.POST)
	public String getQnaBoardList(HttpServletRequest request,Model model)
		throws ServletException,IOException{
		String total = "";
		String url = "qnaBoard/qnaBoardList";
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
		ArrayList<QnaBoardVO> qnaBoardList = null;
		String paging = null;
		
		testVO testVO = new testVO();
		ArrayList<QnaBoardBChuVO> qnaBChuList = null;
		
		testVO.setKey(key);
		testVO.setType(type);
		
		try {
			total= qnaBoardService.getTotal(testVO)+"";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			qnaBoardList = qnaBoardService.getQnaBoardList(Integer.parseInt(tpage),testVO); 
			qnaBChuList = qnaBoardBChuService.listAllQnaBoardBChu();
			paging = qnaBoardService.pageNumber(Integer.parseInt(tpage), testVO);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		model.addAttribute("qnaBoardList", qnaBoardList);
		int n = qnaBoardList.size();
		model.addAttribute("searchCnt",total);
		model.addAttribute("paging", paging);
		model.addAttribute("qnaBChuList", qnaBChuList);

		return url;
	}
	
}
