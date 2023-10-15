package com.ooqn.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ooqn.service.StsInitService;

import jakarta.transaction.Transactional;

@Component
public class TangApplicationRunner implements CommandLineRunner {

    @Autowired
    StsInitService initService;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        new Thread() {
            public void run() {
                System.out.println("初始化数据--------------------------------");
                initService.init();
                System.out.println("初始化数据--------------------------------");
            }
        }.start();
       
        
    }
}
