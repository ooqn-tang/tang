package net.ttcxy.tang.gateway.core.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 配置静态资源的路径
 * @author huanglei
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MyNetWorldLogHandlerInterceptor myNetWorldLogHandlerInterceptor;

    /**
     * 对指定请求拦截
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myNetWorldLogHandlerInterceptor)
                .addPathPatterns("/**").excludePathPatterns("/**/*.*");
    }

    @Override
    public  void  addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}