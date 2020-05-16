package net.ttcxy.tangtang.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 项目启动前调用我
 * @author huanglei
 */
@Component
@Slf4j
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        checkFilePath();
        log.info("我被调用了。。。");
    }

    // todo 启动项目查看系统是否存在外部资源路径，如果不存在，创建
    private void checkFilePath(){

    }

}
