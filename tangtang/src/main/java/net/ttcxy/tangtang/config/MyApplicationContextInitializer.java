package net.ttcxy.tangtang.config;

import net.ttcxy.tangtang.service.AdvertisementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目启动前调用我
 * @author huanglei
 */
@Component
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    private Logger logger = LoggerFactory.getLogger(getClass());




    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        logger.info("我被调用了。。。");
    }

}
