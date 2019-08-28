package com.jnnvc.vblog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 项目启动前调用我
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        logger.info("我被调用了。。。");
    }

}
