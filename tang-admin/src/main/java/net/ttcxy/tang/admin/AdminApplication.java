package net.ttcxy.tang.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huanglei
 */
@SpringBootApplication(scanBasePackages = {"net.ttcxy"})
@MapperScan(basePackages ={"net.ttcxy.tang.db.mapper","net.ttcxy.tang.admin.dao"})
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AdminApplication.class);
        springApplication.run(args);
    }
}