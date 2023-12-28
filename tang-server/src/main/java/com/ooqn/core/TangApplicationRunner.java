package com.ooqn.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ooqn.service.StsInitService;

import jakarta.transaction.Transactional;

@Component
public class TangApplicationRunner implements CommandLineRunner {

    private StsInitService initService;

    public TangApplicationRunner(StsInitService initService) {
        this.initService = initService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        new Thread() {
            public void run() {
                long timeMillis1 = System.currentTimeMillis();
                System.out.println("初始化数据开始=================================");
                initService.init();
                long timeMillis2 = System.currentTimeMillis();
                System.out.println("初始化数据耗时：" + (timeMillis2 - timeMillis1) + "ms");
                System.out.println("初始化数据结束=================================");
            }
        }.start();
    }
}
