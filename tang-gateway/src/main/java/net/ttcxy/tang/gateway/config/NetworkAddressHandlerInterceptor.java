package net.ttcxy.tang.gateway.config;

import net.ttcxy.tang.gateway.entity.LoginUser;
import net.ttcxy.tang.gateway.service.AuthDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 链接所有请求，搜集日志
 * @author huanglei
 */
@Component
public class NetworkAddressHandlerInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthDetailsService authDetailsService;

    /**
     * 记录请求IP
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        LoginUser loginUser = authDetailsService.getUser();
        String userId = loginUser == null ? "未登陆用户": loginUser.getId();
        String address = request.getLocalAddr();
        logger.info("userId ：{}，address ：{}" , userId , address);
        return true;
    }

}