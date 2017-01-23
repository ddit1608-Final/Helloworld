package com.hello.world.dto;

import java.util.Date;

public class FreeBoardVO {

	private String postingNo;
	private String mem_Mail;
	private String freeBoard_Nick;
	private String freeBoard_Title;
	private String freeBoard_Cont;
	private Date freeBoard_WriDate;
	private int freeBoard_Hits;
	private String freeBoard_Pwd;
	
	public String getPostingNo() {
		return postingNo;
	}
	public void setPostingNo(String postingNo) {
		this.postingNo = postingNo;
	}
	public String getMem_Mail() {
		return mem_Mail;
	}
	public void setMem_Mail(String mem_Mail) {
		this.mem_Mail = mem_Mail;
	}
	public String getFreeBoard_Nick() {
		return freeBoard_Nick;
	}
	public void setFreeBoard_Nick(String freeBoard_Nick) {
		this.freeBoard_Nick = freeBoard_Nick;
	}
	public String getFreeBoard_Title() {
		return freeBoard_Title;
	}
	public void setFreeBoard_Title(String freeBoard_Title) {
		this.freeBoard_Title = freeBoard_Title;
	}
	public String getFreeBoard_Cont() {
		return freeBoard_Cont;
	}
	public void setFreeBoard_Cont(String freeBoard_Cont) {
		this.freeBoard_Cont = freeBoard_Cont;
	}
	public Date getFreeBoard_WriDate() {
		return freeBoard_WriDate;
	}
	public void setFreeBoard_WriDate(Date freeBoard_WriDate) {
		this.freeBoard_WriDate = freeBoard_WriDate;
	}
	public int getFreeBoard_Hits() {
		return freeBoard_Hits;
	}
	public void setFreeBoard_Hits(int freeBoard_Hits) {
		this.freeBoard_Hits = freeBoard_Hits;
	}
	public String getFreeBoard_Pwd() {
		return freeBoard_Pwd;
	}
	public void setFreeBoard_Pwd(String freeBoard_Pwd) {
		this.freeBoard_Pwd = freeBoard_Pwd;
	}
	

	@Override
	public String toString() {
		return "FreeBoardVO [postingNo=" + postingNo + ", mem_Mail=" + mem_Mail
				+ ", freeBoard_Nick=" + freeBoard_Nick + ", freeBoard_Title="
				+ freeBoard_Title + ", freeBoard_Cont=" + freeBoard_Cont
				+ ", freeBoard_WriDate=" + freeBoard_WriDate
				+ ", freeBoard_Hits=" + freeBoard_Hits + ", freeBoard_Pwd="
				+ freeBoard_Pwd + "]";
	}
	public FreeBoardVO(String postingNo, String mem_Mail,
			String freeBoard_Nick, String freeBoard_Title,
			String freeBoard_Cont, Date freeBoard_WriDate, int freeBoard_Hits,
			String freeBoard_Pwd) {
		super();
		this.postingNo = postingNo;
		this.mem_Mail = mem_Mail;
		this.freeBoard_Nick = freeBoard_Nick;
		this.freeBoard_Title = freeBoard_Title;
		this.freeBoard_Cont = freeBoard_Cont;
		this.freeBoard_WriDate = freeBoard_WriDate;
		this.freeBoard_Hits = freeBoard_Hits;
		this.freeBoard_Pwd = freeBoard_Pwd;
	}
	
	
	
	public void setSubject(String subject) {
		// TODO Auto-generated method stub
		
	}
	public void setContent(String content) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
