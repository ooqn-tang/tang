package net.ttcxy;

import net.ttcxy.config.MyApplicationContextInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huanglei
 */
@SpringBootApplication
@MapperScan(basePackages ={"net.ttcxy.mapper","net.ttcxy.dao"})
public class TangApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TangApplication.class);
        //关键一步：项目启动前调用我
        springApplication.addInitializers(new MyApplicationContextInitializer());
        springApplication.run(args);
    }

}
