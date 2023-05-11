package com.ooqn.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ooqn.service.InitService;

import jakarta.transaction.Transactional;

@Component
public class MyApplicationRunner implements CommandLineRunner   {

    @Autowired
    InitService initService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("初始化数据--------------------------------");
        try {
            initService.init();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage()+"*****************************");
        }
        System.out.println("初始化数据--------------------------------");
    }
}
