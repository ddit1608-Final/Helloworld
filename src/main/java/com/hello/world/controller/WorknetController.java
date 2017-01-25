package com.hello.world.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/worknet")
public class WorknetController {
	
	@RequestMapping("/worknet.do")
	   public String worknet(HttpSession session) throws ServletException, IOException {
	      String url = "worknet/worknet";

	      return url;
	   }

}
