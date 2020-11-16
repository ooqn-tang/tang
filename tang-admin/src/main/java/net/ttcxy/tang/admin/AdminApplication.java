package net.ttcxy.tang.admin;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

/**
 * @author huanglei
 */
@SpringBootApplication(scanBasePackages = {"net.ttcxy"})
public class AdminApplication {
    public static void main(String[] args) throws JsonProcessingException {
        //SpringApplication springApplication = new SpringApplication(AdminApplication.class);
        //springApplication.run(args);
        System.out.println(JSONUtil.parse(ResponseEntity.ok("OK")));
    }
}