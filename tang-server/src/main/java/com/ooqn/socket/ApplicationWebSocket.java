package com.ooqn.socket;

import com.ooqn.core.security.JwtProvider;
import com.ooqn.entity.dto.UtsAuthorDto;
import com.ooqn.util.SpringUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/api/ws/{jwt}")
@Component
public class ApplicationWebSocket {

	// 成员ID的所有连接
	private static final Map<String, Set<Session>> memberSocketList = new HashMap<>();
	// session
	Map<String, UtsAuthorDto> sessionMap = new HashMap<>();

	public static JSONArray messageList = new JSONArray();

	@OnOpen
	public void onOpen(Session session, @PathParam("jwt") String jwt) {
		Authentication authentication = SpringUtil.getBean(JwtProvider.class).getAuthentication(jwt);
		UtsAuthorDto authorDto = (UtsAuthorDto) authentication.getPrincipal();
		if (authorDto == null) {
			return;
		}
		System.out.printf("成功建立连接~ 当前在线人数为:");
		sessionMap.put(session.getId(), authorDto);
		saveSessionSocket(authorDto.getAuthor().getAuthorId(), session);

		session.getAsyncRemote().sendText(JSONArray.toJSONString(messageList));
	}

	private void saveSessionSocket(String authorId, Session session) {
		Set<Session> set = memberSocketList.get(authorId);
		if (set == null) {
			set = new HashSet<>();
		}
		set.add(session);
		memberSocketList.put(authorId, set);
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println(session);
	}

	@OnMessage
	public void onMessage(String data, Session session) {
		JSONObject parseObject = JSONObject.parseObject(data);
		String type = parseObject.getString("type");
		String text = parseObject.getString("text");
		String to = parseObject.getString("to");

		JSONObject message = new JSONObject();
		message.put("type", type);
		message.put("text", text);
		message.put("form", to);

		messageList.add(message);

		Set<Entry<String, Set<Session>>> entrySet = memberSocketList.entrySet();
		for (Entry<String, Set<Session>> entry : entrySet) {
			entry.getValue().forEach(s -> {
				s.getAsyncRemote().sendText(message.toJSONString());
			});
		}
	}

	@OnError
	public void onError(Session session, Throwable error) {
	}
}