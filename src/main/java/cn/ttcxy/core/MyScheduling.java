package cn.ttcxy.core;

import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.mapper.UtsAuthorMapper;
import cn.ttcxy.service.StsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * 定时器
 */
@Component
@EnableScheduling
public class MyScheduling {

    @Autowired
    private UtsAuthorMapper authorMapper;

    @Autowired
    private StsNoticeService stsNoticeService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MyScheduling() {
    }

    /**
     * 定时更新广告 10分钟更新一次
     */
    @Scheduled(fixedDelay = 1000 * 60 * 10)
    public void advertiseTimerUpdate(){
        List<StsNotice>  advertises = stsNoticeService.selectAllNotice();
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