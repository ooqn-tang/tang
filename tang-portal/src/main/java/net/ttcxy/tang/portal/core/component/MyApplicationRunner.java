package net.ttcxy.tang.portal.core.component;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import net.ttcxy.tang.portal.entity.model.UtsResource;
import net.ttcxy.tang.portal.service.DtsArticleService;
import net.ttcxy.tang.portal.service.StsNoticeService;
import net.ttcxy.tang.portal.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

/**
 *
 * 项目启动后执行这个方法
 * @author huanglei
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
        //urls();
    }

    @Autowired
    private UtsResourceService resourceService;


    public void urls() {
        RequestMappingHandlerMapping mapping = applicationContext
                .getBean(RequestMappingHandlerMapping.class);
        // 获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entryInfo : map.entrySet()) {
            Set<String> patterns = entryInfo.getKey().getPatternsCondition().getPatterns();
            for (String url : patterns) {
                Set<RequestMethod> methods = entryInfo.getKey().getMethodsCondition().getMethods();
                for (RequestMethod method : methods) {
                    try {
                        String urlStr = url.replaceAll("\\{[^}]*}", "*");
                        UtsResource utsResource = new UtsResource();
                        utsResource.setResourceId(IdUtil.objectId());
                        utsResource.setType(method.name());
                        utsResource.setName(urlStr);
                        utsResource.setPath(urlStr);
                        utsResource.setCreateTime(new Date());
                        resourceService.insert(utsResource);
                    }catch (Exception e){
                        System.out.println("数据已经存在");
                    }
                }
            }
        }
    }

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
