package com.hello.world.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;

import com.hello.world.dto.AddressVO;
import com.hello.world.dto.CompanyMemberVO;
import com.hello.world.dto.CrrVO;
import com.hello.world.dto.LangVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.PointVO;
import com.hello.world.service.AddressService;
import com.hello.world.service.CompMemberService;
import com.hello.world.service.CrrService;
import com.hello.world.service.LangService;
import com.hello.world.service.MemberService;
import com.hello.world.service.PointService;

@Controller
@RequestMapping("member")
public class MemberController implements ServletContextAware {

	@Resource(name = "mailSender")
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	private ServletContext servletContext;

	// 2017-01-26 jihyun.Park, session ID처리 추가 해야함...
	// 접속자 처리하기 위해..
	private HashMap<String, String> sessionMap = new HashMap<String, String>();

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

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String findForm() {
		return "member/findIdPw";
	}
	
	@RequestMapping(value = "/changePw", method = RequestMethod.GET)
	public String changePwForm() {
		return "member/changePw";
	}
	
	@RequestMapping(value = "/changePw", method = RequestMethod.POST)
	public String changePw(String mem_mail, String mem_pw) {
		String url = "redirect:/index2.jsp";
		
		MemVO memVO = new MemVO();
		memVO.setMem_mail(mem_mail);
		memVO.setMem_pw(mem_pw);
		
		try {
			memService.changePw(memVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}

	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public String find(String mem_mail) {
		String url = "redirect:/index2.jsp";

		InetAddress ip = null;

		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}

		MimeMessage message = mailSender.createMimeMessage();

		// SimpleMailMessage message = new SimpleMailMessage();
		String htmlContent = "<a href=\"http://" + ip.getHostAddress()
				+ ":8181/world/member/changePw?mem_mail="+mem_mail+"\">패스워드 초기화</a>";

		try {
			message.setSubject("패스워드 초기화");
			message.setText(htmlContent, "UTF-8", "html");
			message.setFrom(new InternetAddress("jihyunkkkkk@daum.net"));
			message.addRecipient(RecipientType.TO,
					new InternetAddress(mem_mail));
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mailSender.send(message);

		try {
			mailSender.send(message);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public String findPwForm() {
		return "member/findPw";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinMemberForm(Model model, HttpSession session) {
		String url = "member/JoinForm";

		if (session.getAttribute("loginUser") != null) {
			url = "redirect:/index2.jsp";
			return url;
		}

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

	@RequestMapping(value = "/joinMenu", method = RequestMethod.GET)
	public String JoinMenu(HttpSession session) {
		String url = "member/JoinMenu";

		if (session.getAttribute("loginUser") != null) {
			url = "redirect:/index2.jsp";
		}

		return url;
	}

	@RequestMapping(value = "/joinCompany", method = RequestMethod.GET)
	public String JoinCompanyForm(HttpSession session) {
		String url = "member/JoinCompForm";

		if (session.getAttribute("loginUser") != null) {
			url = "redirect:/index2.jsp";
		}

		return url;
	}

	@RequestMapping(value = "/joinCompany", method = RequestMethod.POST)
	public String JoinCompany(CompanyMemberVO compMemVo, Model model,
			HttpSession session) {
		String url = "redirect:/index2.jsp";
		int result = 0;

		if (session.getAttribute("loginUser") != null) {
			url = "redirect:/index2.jsp";
			return url;
		}

		try {
			result = compMemService.joinCompMember(compMemVo);

			// 가입 성공시
			if (result == 1) {
				model.addAttribute("join", "success");
			}
			// 가입실패
			else {
				model.addAttribute("join", "fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinMember(MemVO memVO, Model model, HttpSession session) {
		String url = "redirect:/index2.jsp";
		int result = 0;

		if (session.getAttribute("loginUser") != null) {
			url = "redirect:/index2.jsp";
			return url;
		}

		try {
			result = memService.joinMember(memVO);

			// 가입 성공시
			if (result == 1) {
				// 포인트 10점 적립해줘야함.
				PointVO pointVO = new PointVO();
				pointVO.setMem_mail(memVO.getMem_mail());
				pointVO.setPoint("10");
				model.addAttribute("join", "success");
				poingService.insertPoint(pointVO);
			}
			// 가입실패
			else {
				model.addAttribute("join", "fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping(value = "/duplicationCheck", method = RequestMethod.POST)
	@ResponseBody
	public String duplicationCheckID(HttpServletRequest request, Model model) {
		String result = "NotExist";

		String mem_mail = request.getParameter("mem_mail");

		try {
			if (memService.confirmID(mem_mail) == 1) {
				result = "Exit";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String login_mem_mail, String login_mem_pw,
			String prePage, String param, Model model, HttpSession session) {
		String url = "redirect:" + prePage;
		// +"?"+param;
		if (param != "") {
			url = url + "?" + param;
		}

		String sessionId = "";
		System.err.println(prePage);

		MemVO mem = new MemVO();
		int sum = 0;

		mem = memService.getMember(login_mem_mail);

		if (mem == null) {

			if (url.indexOf("?") != -1) {
				if(url.contains("loginResult=pwdMismatch") == true)
					url = url.replace("pwdMismatch", "notexist");
				else if(url.contains("loginResult=notexist") == true)
					url = url.replace("notexist", "notexist");
				else 
					url = url + "&loginResult=notexist";
			} else {
				url = url + "?loginResult=notexist";
			}

			// url = url + "&loginResult:notexist";
		} else {

			// 로그인 성공시.
			if (login_mem_pw.equals(mem.getMem_pw())) {
				try {
					sum = poingService.sumPoint(mem.getMem_mail());
					session.setAttribute("myPoint", sum);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("sockJS", "close");
				session.setAttribute("loginUser", mem);
				sessionId = RequestContextHolder.currentRequestAttributes()
						.getSessionId();
				setSessionMap(mem.getMem_mail(), sessionId);
				// model.addAttribute("loginUserCnt", sessionMap.size());
				// session.setAttribute("loginUserCnt", sessionMap.size());

				// 처리 하는 부분 수정해야함....
				// 2017-01-26 jihyun.Park
				servletContext.setAttribute("loginUserCnt", sessionMap.size());

				if (url.indexOf("?") != -1) {
					if(url.contains("loginResult=notexist") == true)
						url = url.replace("notexist", RequestContextHolder.currentRequestAttributes()
								.getSessionId());
					else if(url.contains("loginResult=pwdMismatch") == true)
						url = url.replace("pwdMismatch", RequestContextHolder.currentRequestAttributes()
								.getSessionId());
					else 
						
					
					
					url = url
							+ "&loginResult="
							+ RequestContextHolder.currentRequestAttributes()
									.getSessionId();
				} else {
					url = url
							+ "?loginResult="
							+ RequestContextHolder.currentRequestAttributes()
									.getSessionId();
				}

				// url = url +
				// "&loginResult:"+RequestContextHolder.currentRequestAttributes().getSessionId();
				System.out.println(RequestContextHolder
						.currentRequestAttributes().getSessionId());
			}
			// 로그인 실패(패스워드 불일치)
			else {
				if (url.indexOf("?") != -1) {
					if(url.contains("loginResult=notexist") == true)
						url = url.replace("notexist", "pwdMismatch");
					else if(url.contains("loginResult=pwdMismatch") == true)
						url = url.replace("pwdMismatch", "pwdMismatch");
					else 
						url = url + "&loginResult=pwdMismatch";
				} else {
					url = url + "?loginResult=pwdMismatch";
				}

			}
		}

		return url;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, String mem_mail) {
		String url = "redirect:/index2.jsp";

		session.removeAttribute("loginUser");
		removeSessionMap(mem_mail);

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
	private void setSessionMap(String mem_mail, String sessionId) {
		sessionMap.put(mem_mail, sessionId);
	}

	private void removeSessionMap(String mem_mail) {
		sessionMap.remove(mem_mail);
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

}
