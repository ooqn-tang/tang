package net.ttcxy.tangtang;

import net.ttcxy.tangtang.config.MyApplicationContextInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="net.ttcxy.tangtang.mapper")
public class TangTangApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BvlogApplication.class, args);

        SpringApplication springApplication = new SpringApplication(TangTangApplication.class);
        //关键一步：将一个或多个initializer加入至spring容器中
        springApplication.addInitializers(new MyApplicationContextInitializer());
        
        springApplication.run(args);
    }

}
