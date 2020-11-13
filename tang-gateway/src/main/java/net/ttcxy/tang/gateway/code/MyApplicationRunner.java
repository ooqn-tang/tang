package net.ttcxy.tang.gateway.code;

import cn.hutool.core.io.FileUtil;
import net.ttcxy.tang.gateway.dao.DtsBlogDao;
import net.ttcxy.tang.gateway.service.StsAdvertiseService;
import net.ttcxy.tang.gateway.service.DtsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${my-file-data-path}")
    private String myFileDataPath;

    @Autowired
    private StsAdvertiseService stsAdvertiseService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private DtsBlogDao dtsBlogDao;

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

        if (!FileUtil.isDirectory(myFileDataPath)) {
            FileUtil.mkdir(myFileDataPath);
        }
        blogService.getRandomBlogs().addAll(dtsBlogDao.selectId());
    }

}
