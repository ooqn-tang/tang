package net.ttcxy.tangtang;

import net.ttcxy.tangtang.config.MyApplicationContextInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextAware;

/**
 * @author huanglei
 */
@SpringBootApplication
@MapperScan(basePackages ={"net.ttcxy.tangtang.mapper","net.ttcxy.tangtang.dao"})
public class  TangTangApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(TangTangApplication.class);

        //关键一步：项目启动前调用我
        springApplication.addInitializers(new MyApplicationContextInitializer());
        
        springApplication.run(args);



    }

}
