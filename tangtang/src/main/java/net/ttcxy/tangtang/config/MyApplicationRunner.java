package net.ttcxy.tangtang.config;

import cn.hutool.core.io.FileUtil;
import net.ttcxy.tangtang.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * 项目启动后执行这个方法
 * @author huanglei
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private ResourceProperties resourceProperties;

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * 检查项目是否外部化静态资源文件，如果设置了，判断外部文件夹是否创建，没有就创建
     */
    private void mkStaticLocations(){

        Objects.requireNonNull(webApplicationContext.getServletContext()).setAttribute("advertises", advertisementService.selectAllAdvertisement());

        String [] staticLocations = resourceProperties.getStaticLocations();
        Arrays.stream(staticLocations).forEach(FileUtil::mkdir);
    }

    @Override
    public void run(ApplicationArguments args) {
        mkStaticLocations();
    }
}
