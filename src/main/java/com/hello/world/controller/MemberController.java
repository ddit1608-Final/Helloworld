package com.hello.world.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.world.dto.LangVO;
import com.hello.world.dto.MemVO;
import com.hello.world.service.LangService;
import com.hello.world.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService memService;

	@Autowired
	private LangService langService;

	public void setLangService(LangService langService) {
		this.langService = langService;
	}

	public void setMemService(MemberService memService) {
		this.memService = memService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinMemberForm(Model model) {
		String url = "member/JoinForm";

		ArrayList<LangVO> langList = new ArrayList<LangVO>();
		try {
			langList = langService.listLangVO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("langList", langList);

		return url;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinMember(MemVO memVO, Model model) {
		String url = "";
		int result = 0;
		try {
			result = memService.joinMember(memVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping(value = "/duplicationCheck", method = RequestMethod.POST)
	public int duplicationCheckID(MemVO memVO, Model model) {
		int result = -1;

		try {
			result = memService.confirmID(memVO.getMem_mail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String mem_mail, String mem_pw, Model model, HttpSession session) {
		String url = "redirect:/index2.jsp";
		
		MemVO mem = new MemVO();
		mem = memService.getMember(mem_mail);
		
		if(mem == null) {
			url = url + "?loginResult:notexist";
		} else {
			
			if(mem_pw.equals(mem.getMem_pw())) {
				session.setAttribute("loginUser", mem);
			} else {
				url = url + "?loginResult:pwdMismatch";
			}
		}

		return url;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		String url = "redirect:/index2.jsp";
		
		session.removeAttribute("loginUser");

		return url;
	}
}
