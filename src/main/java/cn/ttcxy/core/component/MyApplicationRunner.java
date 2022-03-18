package cn.ttcxy.core.component;

import cn.ttcxy.service.DtsArticleService;
import cn.ttcxy.service.StsNoticeService;
import cn.ttcxy.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

/**
 *
 * 项目启动后执行这个方法
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private StsNoticeService stsNoticeService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private DtsArticleService articleService;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) {
        mkStaticLocations();
    }

    @Autowired
    private UtsResourceService resourceService;




    public static void main(String[] args) {
        System.out.println("/post/{a}/{dsf}".replaceAll("\\{[^}]*}","*"));
    }


    /**
     * 检查项目是否外部化静态资源文件，如果设置了，判断外部文件夹是否创建，没有就创建
     */
    private void mkStaticLocations(){
        try{
            Objects.requireNonNull(webApplicationContext.getServletContext()).setAttribute("advertises", stsNoticeService.selectAllNotice());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
