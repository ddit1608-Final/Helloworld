package com.hello.world.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/world")
public class CommonErrorController {

	private static final Logger logger = LoggerFactory.getLogger(CommonErrorController.class);
	
	@RequestMapping(value="/400")
	public String exception400(HttpServletRequest req,Model model){
		logger.info("exception");
		pageErrorLog(req);
		model.addAttribute("msg","잘못된 요청입니다");
		return "common/error";
	}
	@RequestMapping(value="/404")
	public String exception404(HttpServletRequest req,Model model){
		logger.info("exception");
		pageErrorLog(req);
		model.addAttribute("msg","요청하신 페이지는 존재하지 않습니다.");
		return "common/error";
	}
	@RequestMapping(value="/500")
	public String exception500(HttpServletRequest req,Model model){
		logger.info("exception");
		pageErrorLog(req);
		model.addAttribute("msg","서버에 오류가 발생하였습니다.");
		return "common/error";
	}
	
	private void pageErrorLog(HttpServletRequest req){
		// 에러상태
		logger.info("status_code:"+req.getAttribute("javax.servlet.error.status_code"));
		// 예외처리 클래스
		logger.info("exception_type:"+req.getAttribute("javax.servlet.error.exception_type"));
		// 오류메세지
		logger.info("message:"+req.getAttribute("javax.servlet.error.message"));
		// 문제가 되는 uri정보 출력
		logger.info("request_url:"+req.getAttribute("javax.servlet.error.request_url"));
		// 발생한 예외내용 출력
		logger.info("exception:"+req.getAttribute("javax.servlet.error.exception"));
		// 서블릿 명 출력
		logger.info("servlet_name:"+req.getAttribute("javax.servlet.error.servlet_name"));
	}
	
}
