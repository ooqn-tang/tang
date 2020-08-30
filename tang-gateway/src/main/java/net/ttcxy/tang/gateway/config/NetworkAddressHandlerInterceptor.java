package net.ttcxy.tang.gateway.config;

import net.ttcxy.tang.gateway.entity.UserDto;
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
 * @author ：HuangLei
 * @date ：2020/4/22
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
        UserDto userDto = authDetailsService.getUser();
        String userId = userDto == null ? "未登陆用户": userDto.getId();
        String address = request.getLocalAddr();
        logger.info("userId ：{}，address ：{}" , userId , address);
        return true;
    }

}