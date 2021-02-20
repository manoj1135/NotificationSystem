package com.notifier.common;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketTextHandler extends TextWebSocketHandler{
	static List<WebSocketSession> connections = new CopyOnWriteArrayList<WebSocketSession>();
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {

		String payload = message.getPayload();
		JSONObject jsonObject = new JSONObject(payload);
		session.sendMessage(new TextMessage(jsonObject.toString()));
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//the messages will be broadcasted to all users.
		connections.add(session);
	}
	
	public static void broadcastAll(String message) {
		connections.forEach(connection ->{
			try {
				connection.sendMessage(new TextMessage(message));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
