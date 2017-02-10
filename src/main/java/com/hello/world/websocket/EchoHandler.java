package com.hello.world.websocket;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {

	private Map<String, String> users = new ConcurrentHashMap<String, String>();

	public Map<String, String> getUsers() {
		return users;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {

		super.afterConnectionEstablished(session);
		log(session.getId() + " 연결 됨");

		Map<String, Object> map = session.getAttributes();
		String id = (String) map.get("userId");

		users.put(id, session.getId());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		log(session.getId() + " 연결 종료됨");
		users.remove(session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		log(session.getId() + "로부터 메시지 수신: " + message.getPayload());

	}

	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		log(session.getId() + " 익셉션 발생: " + exception.getMessage());
	}

	private void log(String logmsg) {
		System.out.println(new Date() + " : " + logmsg);
	}

}
