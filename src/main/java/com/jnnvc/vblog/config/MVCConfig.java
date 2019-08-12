package com.jnnvc.vblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 配置静态资源的路径
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    public void test() {
        Map<String,String> m = new HashMap();

        for  (Map.Entry<String,String>  me : m.entrySet()){
            System.out.println(me.getKey()+me.getValue());
        }
    }
}