package cn.ttcxy.socket;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import cn.ttcxy.core.security.JwtProvider;
import cn.ttcxy.entity.dto.UtsAuthorDto;
import cn.ttcxy.util.SpringUtil;

@ServerEndpoint(value = "/api/ws/{jwt}")
@Component
public class ApplicationWebSocket {

    // 成员ID的所有连接
    private static final Map<String, Set<ApplicationWebSocket>> memberSocketList = new HashMap<>();
    // session
    Map<String, UtsAuthorDto> sessionMap = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("jwt") String jwt) {
        Authentication authentication = SpringUtil.getBean(JwtProvider.class).getAuthentication(jwt);
        UtsAuthorDto authorDto = (UtsAuthorDto) authentication.getPrincipal();
        if (authorDto == null) {
            return;
        }
        System.out.printf("成功建立连接~ 当前在线人数为:%s%n");
        sessionMap.put(session.getId(), authorDto);
        saveSessionSocket(authorDto.getAuthor().getAuthorId(),this);

    }

    public Set<ApplicationWebSocket> saveSessionSocket(String authorId,ApplicationWebSocket webSocket){
        Set<ApplicationWebSocket> set = memberSocketList.get(authorId);
        if(set == null){
            set = new HashSet<>();
        }
        set.add(webSocket);
        return set;
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {

    }

    @OnError
    public void onError(Session session, Throwable error) {

    }
}
