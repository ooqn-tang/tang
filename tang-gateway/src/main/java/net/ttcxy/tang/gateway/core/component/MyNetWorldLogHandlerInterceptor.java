package net.ttcxy.tang.gateway.core.component;

import net.ttcxy.tang.gateway.entity.model.UtsAuthor;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
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
public class MyNetWorldLogHandlerInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CurrentAuthorService currentAuthorService;

    /**
     * 记录请求IP
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        UtsAuthor author = currentAuthorService.getAuthor();
        String userId = author == null ? "未登陆用户": author.getAuthorId();
        String address = request.getLocalAddr();
        logger.info("userId ：{}，address ：{}" , userId , address);

        return true;
    }

}