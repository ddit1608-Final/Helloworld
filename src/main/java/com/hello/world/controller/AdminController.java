package com.hello.world.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hello.world.dto.MemVO;
import com.hello.world.dto.QnaBoardVO;
import com.hello.world.service.AddressService;
import com.hello.world.service.CompMemberService;
import com.hello.world.service.CrrService;
import com.hello.world.service.LangService;
import com.hello.world.service.MemberService;
import com.hello.world.service.PointService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	final static String ADMIN_PW = "admin!1";
	
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
	
	public void setCompMemService(CompMemberService compMemService) {
		this.compMemService = compMemService;
	}

	public void setMemService(MemberService memService) {
		this.memService = memService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public void setLangService(LangService langService) {
		this.langService = langService;
	}

	public void setCrrService(CrrService crrService) {
		this.crrService = crrService;
	}

	public void setPoingService(PointService poingService) {
		this.poingService = poingService;
	}

	@RequestMapping(value = "/memberManage", method = RequestMethod.GET)
	public String memberManageList(String key, String tpage, Model model) {
		String url= "admin/memberManageList";
		
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
			memberList = memService.getMemberList(Integer.parseInt(tpage),key);
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
		if(admin_pw.equals(ADMIN_PW))
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

}
