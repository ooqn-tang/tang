package net.ttcxy.tang.portal.core.component;

import com.alibaba.fastjson.JSONObject;
import net.ttcxy.tang.portal.entity.model.StsNotice;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.model.UtsAuthorExample;
import net.ttcxy.tang.portal.mapper.UtsAuthorMapper;
import net.ttcxy.tang.portal.mapper.dao.CtsCoinDao;
import net.ttcxy.tang.portal.service.StsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

/**
 * 定时器
 * @author LYJ
 */
@Component
@EnableScheduling
public class MyScheduling {

    @Autowired
    private CtsCoinDao coinDao;

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


    @Scheduled(cron = "0 0 23 * * ?")
    public void b(){
        List<JSONObject> maps = coinDao.selectAuthorCoin();
        for (JSONObject map : maps) {
            UtsAuthor author = new UtsAuthor();
            author.setAuthorId(map.getString("author_id"));
            Integer coin = map.getInteger("coin");
            if (coin!=null&&coin > 0){
                author.setGrade(coin/10);
                authorMapper.updateByPrimaryKeySelective(author);
            }
        }
    }
}
