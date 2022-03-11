package net.ttcxy.tang.portal.core.component;

import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 链接所有请求，搜集日志
 */
@Component
public class MyNetWorldLogHandlerInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

}