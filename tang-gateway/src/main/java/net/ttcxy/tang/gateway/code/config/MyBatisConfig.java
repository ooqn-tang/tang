package net.ttcxy.tang.gateway.code.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@MapperScan(basePackages ={"net.ttcxy.tang.gateway.mapper","net.ttcxy.tang.gateway.dao"})
@Component
public class MyBatisConfig {
}
