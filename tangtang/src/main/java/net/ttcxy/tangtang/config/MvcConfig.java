package net.ttcxy.tangtang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置静态资源的路径
 * @author huanglei
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private NetworkAddressHandlerInterceptor networkAddressHandlerInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/public/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(networkAddressHandlerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/*.html", "/**/*.js","/**/*.css","/**/*.png","/**/*.gif","/**/*.jpg","/**/*.ttf","/**/*.woff","/**/*.woff2");
    }
}