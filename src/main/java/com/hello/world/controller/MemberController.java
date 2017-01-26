package com.hello.world.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;

import com.hello.world.dto.AddressVO;
import com.hello.world.dto.CrrVO;
import com.hello.world.dto.LangVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.PointVO;
import com.hello.world.service.AddressService;
import com.hello.world.service.CrrService;
import com.hello.world.service.LangService;
import com.hello.world.service.MemberService;
import com.hello.world.service.PointService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	// 2017-01-26 jihyun.Park, session ID처리 추가 해야함...
	// 접속자 처리하기 위해..
	private HashMap<String, String> sessionMap = new HashMap<String, String>();

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

	public void setLangService(LangService langService) {
		this.langService = langService;
	}

	public void setMemService(MemberService memService) {
		this.memService = memService;
	}

	public void setAddrService(AddressService addressService) {
		this.addressService = addressService;
	}

	public void setCrrService(CrrService crrService) {
		this.crrService = crrService;
	}

	public void setPoingService(PointService poingService) {
		this.poingService = poingService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinMemberForm(Model model) {
		String url = "member/JoinForm";

		ArrayList<LangVO> langList = new ArrayList<LangVO>();
		ArrayList<CrrVO> crrList = new ArrayList<CrrVO>();
		
		try {
			langList = langService.listLangVO();
			crrList = crrService.listCrrVO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("langList", langList);
		model.addAttribute("crrList", crrList);

		return url;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinMember(MemVO memVO, Model model) {
		String url = "redirect:/index2.jsp";
		int result = 0;

		try {
			result = memService.joinMember(memVO);

			// 가입 성공시
			if (result == 1) {
				// 포인트 10점 적립해줘야함.
				PointVO pointVO = new PointVO();
				pointVO.setMem_mail(memVO.getMem_mail());
				pointVO.setPoint("10");
				model.addAttribute("join","success");
				poingService.insertPoint(pointVO);
			}
			// 가입실패
			else {
				model.addAttribute("join","fail");
			}
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
	public String login(String login_mem_mail, String login_mem_pw,
			Model model, HttpSession session) {
		String url = "redirect:/index2.jsp";

		MemVO mem = new MemVO();
		int sum = 0;

		mem = memService.getMember(login_mem_mail);

		if (mem == null) {
			url = url + "?loginResult:notexist";
		} else {

			if (login_mem_pw.equals(mem.getMem_pw())) {
				try {
					sum = poingService.sumPoint(mem.getMem_mail());
					session.setAttribute("myPoint", sum);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("loginUser", mem);
				url = url + "?loginResult:"+RequestContextHolder.currentRequestAttributes().getSessionId();
				System.out.println(RequestContextHolder.currentRequestAttributes().getSessionId());
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

	@RequestMapping(value = "/findZipNum", method = RequestMethod.GET)
	public String findZipNum() {
		String url = "member/findZipNum";

		return url;
	}

	@RequestMapping(value = "/findZipNum", method = RequestMethod.POST)
	public String findZipNumByDong(String dong, Model model) {
		String url = "member/findZipNum";

		if (dong != null && dong.trim().equals("") == false) {
			try {
				ArrayList<AddressVO> addressList = addressService
						.selectAddressByDong(dong.trim());
				model.addAttribute("addressList", addressList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return url;
	}
	
	// 2017-01-26 jihyun.Park, session ID처리 추가 해야함...
	private void setSessionMap() {
		
	}
	
}
