package com.hello.world.controller;

import org.springframework.web.socket.WebSocketSession;

public class CommWriterInfo {
	String mem_mail;
	String today;


	public String getMem_mail() {
		return mem_mail;
	}

	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

}
