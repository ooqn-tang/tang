package net.ttcxy.tang.core.component;

import net.ttcxy.tang.service.DtsBlogService;
import net.ttcxy.tang.service.StsAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

/**
 *
 * 项目启动后执行这个方法
 * @author huanglei
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private StsAdvertiseService stsAdvertiseService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private DtsBlogService blogService;

    @Override
    public void run(ApplicationArguments args) {
        mkStaticLocations();
    }

    /**
     * 检查项目是否外部化静态资源文件，如果设置了，判断外部文件夹是否创建，没有就创建
     */
    private void mkStaticLocations(){
        Objects.requireNonNull(webApplicationContext.getServletContext())
                .setAttribute("advertises", stsAdvertiseService.selectAllAdvertise());
    }

}
