package com.hello.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.world.service.NaverNewsService;


@Controller
@RequestMapping("/news")
public class NaverNewsController {

	@Autowired
	private NaverNewsService service;


	@RequestMapping("/news")
	public ModelAndView newsList(@RequestParam(required = true) String keyword) {
		ModelAndView mav = new ModelAndView();

		if (keyword != null) {
			mav.addObject("newsList", service.searchNews(keyword, 10, 1));
		}
		mav.setViewName("newsList");
		return mav;
	}

}
