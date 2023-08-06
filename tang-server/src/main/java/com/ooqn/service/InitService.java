package com.ooqn.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.ooqn.entity.model.UtsResource;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class InitService {

    @PersistenceContext
    EntityManager entityManager;

     @Autowired
    WebApplicationContext applicationContext;

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    private UtsResourceService resourceService;

    @Transactional
    public void init() {
        try {
            
            Object singleResult = entityManager.createNativeQuery("select count(1) from uts_author").getSingleResult();
            if (singleResult != null && Integer.parseInt(singleResult.toString()) > 0) {
                return;
            }
            
            entityManager.createNativeQuery("INSERT INTO UTS_AUTHOR (AUTHOR_ID,MAIL,NICKNAME,PASSWORD,REFRESH_TIME,SIGNATURE,UPDATE_TIME,USERNAME) VALUES ('1','admin@admin.com','admin','$2a$10$oudWqrtYf8t/abWwDxg7HucYMx3.FC7/9EWQW835PMTZJ/zbTHtBO','2023-04-09 22:09:38.427','admin','2023-04-09 22:09:38.427','admin')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_AUTHOR_ROLE (AUTHOR_ROLE_ID,AUTHOR_ID,CREATE_TIME,ROLE_ID) VALUES ('1','1','2023-04-09 22:09:38.453','1')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE (RESOURCE_ID,CREATE_TIME,NAME,\"PATH\",STATE,\"TYPE\") VALUES ('1','2023-04-09 22:56:42.19','ALL','/**',9,'GET')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE (RESOURCE_ID,CREATE_TIME,NAME,\"PATH\",STATE,\"TYPE\") VALUES ('2','2023-04-09 22:56:42.19','ALL','/**',9,'POST')").executeUpdate();       
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE (RESOURCE_ID,CREATE_TIME,NAME,\"PATH\",STATE,\"TYPE\") VALUES ('3','2023-04-09 22:56:42.19','ALL','/**',9,'PUT')").executeUpdate();       
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE (RESOURCE_ID,CREATE_TIME,NAME,\"PATH\",STATE,\"TYPE\") VALUES ('4','2023-04-09 22:56:42.19','ALL','/**',9,'DELETE')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE_ROLE (RESOURCE_ROLE_ID,CREATE_TIME,RESOURCE_ID,ROLE_ID) VALUES ('1','2023-04-09 23:01:27.39','1','1')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE_ROLE (RESOURCE_ROLE_ID,CREATE_TIME,RESOURCE_ID,ROLE_ID) VALUES ('1','2023-04-09 23:01:27.39','2','1')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE_ROLE (RESOURCE_ROLE_ID,CREATE_TIME,RESOURCE_ID,ROLE_ID) VALUES ('1','2023-04-09 23:01:27.39','3','1')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE_ROLE (RESOURCE_ROLE_ID,CREATE_TIME,RESOURCE_ID,ROLE_ID) VALUES ('1','2023-04-09 23:01:27.39','4','1')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_ROLE (ROLE_ID,CREATE_TIME,REFRESH_TIME,ROLE_NAME,ROLE_VALUE,UPDATE_TIME) VALUES ('1','2023-04-09 23:53:13.756','2023-04-09 22:53:01.997','超级管理员','ROLE_ADMIN','2023-04-09 22:53:28.379')").executeUpdate();
            
            Map<RequestMappingInfo, HandlerMethod> methodMap = requestMappingHandlerMapping.getHandlerMethods();
            for (RequestMappingInfo info : methodMap.keySet()){
                
                for (String patternValues : info.getPatternValues()) {
                    // patternValues {到下一个} 之间的内容用*代替
                    String path = patternValues.replaceAll("\\{[^}]*\\}", "*");
                    for (RequestMethod method : info.getMethodsCondition().getMethods()) {
                        System.out.println(method.name());
                        System.out.println(path);
                        try {
                            UtsResource resource = new UtsResource();
                            resource.setName(path);
                            resource.setPath(path);
                            resource.setType(method.name());
                            resource.setState(1);
                            resource.setResourceId(IdUtil.objectId());
                            resource.setCreateTime(DateUtil.date());
                            resourceService.insert(resource);
                        } catch (Exception e) {}
                    }
                }
            }
        
        
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()+"*****************************");
        }
    }
}
