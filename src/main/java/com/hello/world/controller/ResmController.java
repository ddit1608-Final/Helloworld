package com.hello.world.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.world.dto.FreeBoardVO;
import com.hello.world.dto.MemVO;
import com.hello.world.dto.ResmVO;
import com.hello.world.service.ResmService;


@Controller
@RequestMapping("/resm")
public class ResmController {
	
	@Autowired
	ResmService resmService;
	
	public void setResmService(ResmService resmService) {
		this.resmService = resmService;
	}
	
	 @RequestMapping("/resmList.do")
	   public String ResmList(HttpSession session, Model model)
	         throws ServletException, IOException {
	      String url = "resm/resmList";
	      
	      MemVO loginUser = (MemVO) session.getAttribute("loginUser");
	      
	      ArrayList<ResmVO> resmList=null;
	      resmList = resmService.getResmList(loginUser.getMem_mail());
	      
	      model.addAttribute("resmList", resmList);
	      
	      return url;
	 }
	 
	 @RequestMapping("/resmDetail.do")
	   public String ResmDetail(@RequestParam String resm_id, HttpSession session,
	         Model model) throws ServletException, IOException {

	      String url = "resm/resmDetail";
	      /*MemVO loginUser = (MemVO) session.getAttribute("loginUser");*/
	      ResmVO resmVO = resmService.getResmDetail(resm_id);
	      model.addAttribute("resmVO", resmVO);
	      return url;
	   }



	@RequestMapping("/resmWriteForm.do")
	   public String ResmWriteForm(HttpSession session) throws ServletException,
	         IOException {
	      String url = "resm/resmForm";

	     /* MemVO loginUser = (MemVO) session.getAttribute("loginUser");*/

	      return url;
	   }
	
	
	
	@RequestMapping("/resmWrite.do")
	      public String ResmWriteForm(ResmVO resmVO, HttpSession session)
	  			throws ServletException, IOException {
	  		String url = "redirect:freeBoardList.do";

	  		//MemVO loginUser = (MemVO) session.getAttribute("loginUser");
	  		System.out.println("getResm_id"+resmVO.getResm_id());
	  		System.out.println("getMem_mail"+resmVO.getMem_mail());
	  		System.out.println("getSidn_code"+resmVO.getSidn_code());
	  		System.out.println("getLcse_code"+resmVO.getLcse_code());
	  		System.out.println("getAcdmcr_code"+resmVO.getAcdmcr_code());
	  		System.out.println("getIdpic_code"+resmVO.getIdpic_code());
	  		System.out.println("getResm_regno"+resmVO.getResm_regno());
	  		System.out.println("getMilt_code"+resmVO.getMilt_code());
	  		System.out.println("getResm_hob"+resmVO.getResm_hob());
	  		System.out.println("getResm_like"+resmVO.getResm_like());	  		
	  		resmVO.setResm_wri_date(new Timestamp(System.currentTimeMillis()));
	  		
	  		System.out.println(resmVO.getResm_wri_date());
	  		
	  		
	  		resmService.insertResm(resmVO);	  		
	  		
	  		return url;
	   }
	
	@RequestMapping("/resmUpdateForm.do")
	public String ResmUpdateForm(@RequestParam String resm_id, HttpSession session,
	         Model model) throws ServletException, IOException {

	      String url = "resm/resmUpdate";
	      /*MemVO loginUser = (MemVO) session.getAttribute("loginUser");*/
	      ResmVO resmVO = resmService.getResmDetail(resm_id);
	      model.addAttribute("resmVO", resmVO);
	      return url;
	   }
	@RequestMapping(value="/resmUpdate.do",method=RequestMethod.POST)
	public String ResmUpate(ResmVO resmVO, HttpSession session)	throws ServletException, IOException {
		String url = "redirect:resmList.do";
		
		/*MemVO loginUser = (MemVO) session.getAttribute("loginUser");*/
		
		System.out.println(resmVO);
	
		resmService.updateResm(resmVO);
		
		
		return url;
	}
	
	@RequestMapping(value="/resmDelete.do")
	public String deleteFreeBoard(@RequestParam String resm_id,
			HttpSession session)
			throws ServletException, IOException {
		String url = "redirect:resmList.do";
		
		//MemVO loginUser = (MemVO) session.getAttribute("loginUser");	
	
		resmService.deleteFreeBoard(resm_id);
		
		return url;
	}
	

}
