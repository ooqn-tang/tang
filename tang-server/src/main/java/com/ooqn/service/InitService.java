package com.ooqn.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class InitService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void init() {
        try {
            
            Object singleResult = entityManager.createNativeQuery("select count(1) from uts_author").getSingleResult();
            if (singleResult != null && Integer.parseInt(singleResult.toString()) > 0) {
                return;
            }
            
            entityManager.createNativeQuery("INSERT INTO UTS_AUTHOR (AUTHOR_ID,MAIL,NICKNAME,PASSWORD,REFRESH_TIME,SIGNATURE,UPDATE_TIME,USERNAME) VALUES ('1','admin@admin.com','admin','$2a$10$0oTP5waZjfrG.I/ouqDPc.CcPGZmw2ZNxJeWCxK7ILVFIr2DLO9lG','2023-04-09 22:09:38.427','admin','2023-04-09 22:09:38.427','admin')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_AUTHOR_ROLE (AUTHOR_ROLE_ID,AUTHOR_ID,CREATE_TIME,ROLE_ID) VALUES ('1','1','2023-04-09 22:09:38.453','1')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE (RESOURCE_ID,CREATE_TIME,NAME,\"PATH\",STATE,\"TYPE\") VALUES ('1','2023-04-09 22:56:42.19','ALL','/**',9,'GET')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE (RESOURCE_ID,CREATE_TIME,NAME,\"PATH\",STATE,\"TYPE\") VALUES ('2','2023-04-09 22:56:42.19','ALL','/**',9,'POST')").executeUpdate();       
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE (RESOURCE_ID,CREATE_TIME,NAME,\"PATH\",STATE,\"TYPE\") VALUES ('3','2023-04-09 22:56:42.19','ALL','/**',9,'PUT')").executeUpdate();       
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE (RESOURCE_ID,CREATE_TIME,NAME,\"PATH\",STATE,\"TYPE\") VALUES ('4','2023-04-09 22:56:42.19','ALL','/**',9,'DELETE')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_RESOURCE_ROLE (RESOURCE_ROLE_ID,CREATE_TIME,RESOURCE_ID,ROLE_ID) VALUES ('1','2023-04-09 23:01:27.39','1','1')").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO UTS_ROLE (ROLE_ID,CREATE_TIME,REFRESH_TIME,ROLE_NAME,ROLE_VALUE,UPDATE_TIME) VALUES ('1','2023-04-09 23:53:13.756','2023-04-09 22:53:01.997','超级管理员','ROLE_ADMIN','2023-04-09 22:53:28.379')").executeUpdate();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()+"*****************************");
        }
    }
}
