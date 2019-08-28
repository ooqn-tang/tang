package com.jnnvc.vblog;

import com.jnnvc.vblog.config.MyApplicationContextInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan(basePackages ="com.jnnvc.vblog.mapper")
public class BvlogApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BvlogApplication.class, args);

        SpringApplication springApplication = new SpringApplication(BvlogApplication.class);
        //关键一步：将一个或多个initializer加入至spring容器中
        springApplication.addInitializers(new MyApplicationContextInitializer());
        
        springApplication.run(args);
    }

}
