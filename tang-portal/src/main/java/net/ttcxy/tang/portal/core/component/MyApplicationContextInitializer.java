package net.ttcxy.tang.portal.core.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 项目启动前调用我
 * @author huanglei
 */
@Component
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        checkFilePath();
        logger.info("我被调用了。。。");
    }

    private void checkFilePath(){

    }
}
