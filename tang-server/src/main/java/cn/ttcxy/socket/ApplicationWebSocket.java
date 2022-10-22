package cn.ttcxy.socket;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import org.springframework.security.core.Authentication;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.ttcxy.core.security.JwtProvider;
import cn.ttcxy.entity.dto.UtsAuthorDto;
import cn.ttcxy.util.SpringUtil;

//@ServerEndpoint(value = "/api/ws/{jwt}")
//@Component
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
        saveSessionSocket(authorDto.getAuthor().getAuthorId(),session);

        session.getAsyncRemote().sendText(JSONArray.toJSONString(messageList));

    }

    private void saveSessionSocket(String authorId,Session session){
        Set<Session> set = memberSocketList.get(authorId);
        if(set == null){
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
        for (Entry<String,Set<Session>> entry : entrySet) {
            entry.getValue().forEach(s -> {
                s.getAsyncRemote().sendText(message.toJSONString());
            });
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {

    }
}
