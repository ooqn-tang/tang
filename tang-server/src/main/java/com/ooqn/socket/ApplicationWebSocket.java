package com.ooqn.socket;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.ooqn.entity.dto.UtsAuthorDto;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/api/ws/{jwt}")
@Component
public class ApplicationWebSocket {

	private static final Map<String, Set<Session>> memberSocketList = new HashMap<>();

	Map<String, UtsAuthorDto> sessionMap = new HashMap<>();

	public static JSONArray messageList = new JSONArray();

	@OnOpen
	public void onOpen(Session session, @PathParam("jwt") String jwt) {
		
	}

	@OnClose
	public void onClose(Session session) {
		
	}

	@OnMessage
	public void onMessage(String data, Session session) {
	
	}

	@OnError
	public void onError(Session session, Throwable error) {
	}
}
