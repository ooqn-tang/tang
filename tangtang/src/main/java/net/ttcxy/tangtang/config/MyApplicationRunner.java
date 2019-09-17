package net.ttcxy.tangtang.config;

import cn.hutool.core.io.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 项目启动后执行这个方法
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    ResourceProperties resourceProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        mkStaticLocations();
    }

    //检查项目是否外部化静态资源文件，如果设置了，判断外部文件夹是否创建，没有就创建
    private void mkStaticLocations(){

        String [] staticLocations = resourceProperties.getStaticLocations();

        Arrays.stream(staticLocations).forEach(string ->{
            FileUtil.mkdir(string);
        });
    }
}
