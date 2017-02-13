package com.hello.world.websocket;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.hello.world.dto.MessageVO;

public class EchoHandler extends TextWebSocketHandler {

	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();

	public Map<String, WebSocketSession> getUsers() {
		return users;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {

		super.afterConnectionEstablished(session);
		log(session.getId() + " 연결 됨");

		Map<String, Object> map = session.getAttributes();
		String id = (String) map.get("userId");

		users.put(id, session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		log(session.getId() + " 연결 종료됨");
		
		Map<String, Object> map = session.getAttributes();
		String id = (String) map.get("userId");
		
		users.remove(id);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		log(session.getId() + "로부터 메시지 수신: " + message.getPayload());
		String fromUser = "";
		for(String commUser : users.keySet()) {
			if(users.get(commUser).equals(session)) {
				fromUser = commUser;
			}
		}
		MessageVO messageVO = MessageVO.converMessage(message.getPayload());
		String user = messageVO.getTo();
		System.err.println(users.get(user));
		users.get(user).sendMessage(
				new TextMessage("회원 " +fromUser +"가 회원님이 작성하신 게시물에 댓글을 작성했습니다."
						+ "\n" + messageVO.getMessage()));

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
