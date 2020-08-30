package net.ttcxy.tang.gateway;

import net.ttcxy.tang.gateway.config.MyApplicationContextInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huanglei
 */
@SpringBootApplication
@MapperScan(basePackages ={"net.ttcxy.tang.gateway.mapper","net.ttcxy.tang.gateway.dao"})
public class TangApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TangApplication.class);
        //关键一步：项目启动前调用我
        springApplication.addInitializers(new MyApplicationContextInitializer());
        springApplication.run(args);
    }

}
