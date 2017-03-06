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

import com.hello.world.dto.IfShrBoardVO;
import com.hello.world.dto.PostingTypeVO;
import com.hello.world.dto.ScrapVO;
import com.hello.world.dto.testVO;
import com.hello.world.service.ScrapService;

/**
 * 
 * 마이페이지에서 스크랩한 구인광고글을 확인할수 있음
 *
 */
@Controller
@RequestMapping("mypage")
public class ScrapController {

	@Autowired
	ScrapService scrapService;

	// 전체 리스트 보여주기
	@RequestMapping(value = "/scrapList", method = RequestMethod.GET)
	public String scrapList(HttpSession session, Model model,
			HttpServletRequest request) throws ServletException, IOException {
		String url = "myPage/scrapList";

		String total = "";
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
		testVO.setType("wantedAuthNo");
		try {
			total = scrapService.getTotal(testVO) + "";
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		ArrayList<ScrapVO> scrapList = null;
		String paging = null;
		try {
			scrapList = scrapService.getScrapList(Integer.parseInt(tpage), testVO);
			paging = scrapService.pageNumber(Integer.parseInt(tpage),testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("scrapList", scrapList);
		int n = scrapList.size();
		model.addAttribute("scrapListSize", n);
		model.addAttribute("paging", paging);
		model.addAttribute("searchCnt", total);
		return url;
	}

}
