package net.ttcxy.tang.gateway.config;

import net.ttcxy.tang.model.DtsAdvertise;
import net.ttcxy.tang.gateway.service.StsAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * 定时器
 * @author huanglei
 */
@Component
@EnableScheduling
public class MyScheduling {

    @Autowired
    private StsAdvertiseService stsAdvertiseService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * 定时更新广告 10分钟更新一次
     */
    @Scheduled(fixedDelay = 1000 * 60 * 10)
    public void advertiseTimerUpdate(){
        List<DtsAdvertise>  advertises = stsAdvertiseService.selectAllAdvertise();
        if (advertises != null){
            ServletContext servletContext = webApplicationContext.getServletContext();
            if (servletContext!=null){
                servletContext.setAttribute("advertises",advertises );
            }
        }
    }

    /**
     * 定时更新随机博客 10分钟更新一次
     */
    @Scheduled(fixedDelay = 1000 * 60 * 10)
    public void a(){

    }
}
