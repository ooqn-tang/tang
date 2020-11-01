package net.ttcxy.tang.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

/**
 * @author huanglei
 */
@SpringBootApplication
@MapperScan(basePackages ={"net.ttcxy.tang.mapper","net.ttcxy.tang.gateway.dao"})
public class TangApplication {

    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(TangApplication.class);
//        //关键一步：项目启动前调用我
//        springApplication.addInitializers(new MyApplicationContextInitializer());
//        springApplication.run(args);

        List<String> strings = Arrays.asList("1", "2", "2");

    }


}
