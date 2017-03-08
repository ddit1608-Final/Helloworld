package com.hello.world.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.hello.world.dto.MemVO;
import com.hello.world.dto.ResmVO;
import com.hello.world.service.ResmService;


@Controller
@RequestMapping("/resm")
public class ResmController {
	@Autowired
	WebApplicationContext ctx;
	
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



	@RequestMapping(value="/resmWriteForm.do", method=RequestMethod.GET)
	   public String ResmWriteForm(HttpSession session) throws ServletException,
	         IOException {
	      String url = "resm/resmForm";

	     /* MemVO loginUser = (MemVO) session.getAttribute("loginUser");*/

	      return url;
	   }
	
	
	
	@RequestMapping(value="/resmWriteForm.do", method=RequestMethod.POST)
	      public String ResmWriteForm(ResmVO resmVO, HttpSession session,HttpServletRequest request,
	    		  @RequestParam("uploadfile")MultipartFile uploadfile)
	  			throws ServletException, IOException {
	  		String url = "redirect:resmList.do";
	        
	  		ServletContext context = ctx.getServletContext();
			String uploadFilePath ="/resources/file";
			uploadFilePath = context.getRealPath(uploadFilePath);
	     
	        if(!uploadfile.isEmpty()){
	           File file = new File(uploadFilePath, "$$"+System.currentTimeMillis()+uploadfile.getOriginalFilename());
	           String fileName = file.getName();
	           int pos = fileName.lastIndexOf(".");
	           try{
	           uploadfile.transferTo(file);
	           } catch (IllegalStateException e) {
	              e.printStackTrace();
	           } catch (IOException e) {
	              e.printStackTrace();
	           }
	           
	           resmVO.setIdpic_code(fileName);
	        }
	        
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
	@RequestMapping(value="/resmUpdateForm.do",method=RequestMethod.POST)
	public String ResmUpate(ResmVO resmVO, HttpSession session,HttpServletRequest request,
  		  @RequestParam("uploadfile")MultipartFile uploadfile, Model model)
  				  throws ServletException, IOException {
		
		String url = "redirect:resmList.do";
		
		/*MemVO loginUser = (MemVO) session.getAttribute("loginUser");*/
		ServletContext context = ctx.getServletContext();
		String uploadFilePath ="/resources/file";
		uploadFilePath = context.getRealPath(uploadFilePath);
	     
        if(!uploadfile.isEmpty()){
           File file = new File(uploadFilePath, "$$"+System.currentTimeMillis()+uploadfile.getOriginalFilename());
           String fileName = file.getName();
           int pos = fileName.lastIndexOf(".");
           try{
           uploadfile.transferTo(file);
           } catch (IllegalStateException e) {
              e.printStackTrace();
           } catch (IOException e) {
              e.printStackTrace();
           }
           
           resmVO.setIdpic_code(fileName);
        }
        else{
        	resmVO.setIdpic_code(request.getParameter("nn"));
        }
		
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