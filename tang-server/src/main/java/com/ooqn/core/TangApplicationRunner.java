package com.ooqn.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.ooqn.service.InitService;

import jakarta.transaction.Transactional;

@Component
public class TangApplicationRunner implements CommandLineRunner {

    @Autowired
    InitService initService;

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        new Thread() {
            public void run() {
                System.out.println("初始化数据--------------------------------");
                try {
                    initService.init();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage() + "*****************************");
                }
                System.out.println("初始化数据--------------------------------");
            }
        }.start();
       
        Map<RequestMappingInfo, HandlerMethod> methodMap = requestMappingHandlerMapping.getHandlerMethods();
        for (RequestMappingInfo info : methodMap.keySet()){
            for (String patternValues : info.getPatternValues()) {
                String path = patternValues.replaceAll("\\{[^}]*\\}", "*");
                for (RequestMethod method : info.getMethodsCondition().getMethods()) {
                    HandlerMethod handlerMethod = methodMap.get(info);
                    if (handlerMethod.getMethod().isAnnotationPresent(NotRole.class)) {
                        Map<String, String> map = new HashMap<>();
                        map.put("method", method.name());
                        map.put("path", path);
                        TangConfig.notRoleList.add(map);
                    }
                }
            }
        }
    }
}
