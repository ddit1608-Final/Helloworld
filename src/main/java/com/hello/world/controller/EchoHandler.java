package com.hello.world.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
	
	
	
	private Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	private List<WebSocketSession> connectsUsers;
	
	
	//서버에 연결한 사용자들 저장
	public EchoHandler(){
		connectsUsers = new ArrayList<WebSocketSession>();
	}

	
	
	
	//이벤트 처리할 수 있는 메소드선언
	 
	
	
	@Override//접속관련이벤트 메소드, WebSocketSession접속한 사용자
	public void afterConnectionEstablished(WebSocketSession session)throws Exception {
		logger.info(session.getId()+"님 접속");
		logger.info("연결IP: "+session.getRemoteAddress().getHostName());
		connectsUsers.add(session); //접속담당 이벤트 메소드에 세션을 추가하는 구문을 추가한다.
	}

	
	
/*	2가지이벤트처리
	** Send-> 클라이언트가 서버에게 메세지 보냄
	** Emit-> 서버에 연결되어 있는 클라이언트에게 메시지 보냄
	WebSocketSession 메시지를 보낸 클라이언트
	TextMessage 메세지의 내용*/
	
    @Override
	protected void handleTextMessage(WebSocketSession session,TextMessage message) throws Exception {
		//Payload = 사용자가 보낸 메시지
    	logger.info(session.getId()+"님이 메시지 성공" + message.getPayload());
    	
    	for(WebSocketSession websocketSession : connectsUsers){
    		//보낸 사용자는 받지 않기 위한 조건문
    		if(!session.getId().equals(websocketSession)){
    			websocketSession.sendMessage( new TextMessage(session.getRemoteAddress().getHostName()+ "->"+message.getPayload()));
    		}
    	}
	}

    
    
    /*클라이언트가 서버와 연결 종료
    WebSocketSession 연결을 끊은 클라이언트
    CloseStatus 연결 상태 (확인필요)*/

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		logger.info(session.getId()+"님 접속 종료");
		connectsUsers.remove(session); //접속담당 이벤트 메소드에 세션 삭제
	}
}
