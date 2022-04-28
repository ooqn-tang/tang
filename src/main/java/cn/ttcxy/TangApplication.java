package cn.ttcxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.ttcxy"})
@MapperScan("cn.ttcxy.mapper")
public class TangApplication {

	public static void main(String[] args) {
		SpringApplication.run(TangApplication.class, args);
	}

}
