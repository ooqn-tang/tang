package net.ttcxy.tang.gateway.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置静态资源的路径
 * @author huanglei
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private NetworkAddressHandlerInterceptor networkAddressHandlerInterceptor;

    /**
     * 拦截器，过滤这些请求
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(networkAddressHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/**/*.*");
    }
}