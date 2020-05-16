package net.ttcxy.tangtang.config;

import lombok.extern.slf4j.Slf4j;
import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 链接所有请求，搜集日志
 * @author ：HuangLei
 * @date ：2020/4/22 0022 20:12
 */
@Component
@Slf4j
public class NetworkAddressHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthDetailsImpl authDetails;

    /**
     * 记录请求IP
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        UserDto userDto = authDetails.getUser();
        String userId = userDto == null ? "未登陆用户": userDto.getId();
        String address = request.getLocalAddr();
        log.info("userId ：{}，address ：{}" , userId , address);
        return true;
    }

}