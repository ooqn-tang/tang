package net.ttcxy.tang.gateway;

import net.ttcxy.tang.gateway.config.MyApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huanglei
 */
@SpringBootApplication(scanBasePackages = {"net.ttcxy"})
public class TangApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TangApplication.class);
        //关键一步：项目启动前调用我
        springApplication.addInitializers(new MyApplicationContextInitializer());
        springApplication.run(args);
    }
}
