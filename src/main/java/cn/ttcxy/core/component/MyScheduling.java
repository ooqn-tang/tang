package cn.ttcxy.core.component;

import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.mapper.UtsAuthorMapper;
import cn.ttcxy.mapper.dao.CtsCoinDao;
import cn.ttcxy.service.StsNoticeService;
import com.alibaba.fastjson.JSONObject;
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
