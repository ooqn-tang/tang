package com.ooqn.chat;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;


@Configuration
@EnableWebSocket
public class MonsterWebSocketConfigurer  implements WebSocketConfigurer {

    @Autowired
    MonsterWebSocketHandler monsterWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
        .addHandler(monsterWebSocketHandler, "/_monster/*")
        .addInterceptors(monsterHandshakeInterceptor())
        .setAllowedOrigins("*");
    }

    @Bean
    HandshakeInterceptor monsterHandshakeInterceptor(){
        return new HandshakeInterceptor() {
            @Override
            public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> attributes) throws Exception {
                return true;
            }
            @Override
            public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, @Nullable Exception arg3) {
                
            }
        };
    }
}
