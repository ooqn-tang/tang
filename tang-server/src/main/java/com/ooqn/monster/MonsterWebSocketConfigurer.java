package com.ooqn.monster;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import io.micrometer.common.lang.Nullable;

@Configuration
@EnableWebSocket
public class MonsterWebSocketConfigurer  implements WebSocketConfigurer {

    @Autowired
    MonsterWebSocketHandler myWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
        .addHandler(myWebSocketHandler, "/_monster/*")
        .addInterceptors(myHandshakeInterceptor())
        .setAllowedOrigins("*");
    }

    @Bean
    HandshakeInterceptor myHandshakeInterceptor(){
        return new HandshakeInterceptor() {
            
            @Override
            public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> attributes) throws Exception {
                ServletServerHttpRequest req = (ServletServerHttpRequest) request;
                String token = req.getServletRequest().getParameter("token");
                return true;
            }

            @Override
            public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, @Nullable Exception arg3) {
                
            }
            
        };
    }

    
}
