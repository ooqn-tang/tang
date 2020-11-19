package net.ttcxy.tang.gateway.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@MapperScan(basePackages ={"net.ttcxy.tang.db.mapper","net.ttcxy.tang.db.dao"})
@Component
public class MyBatisConfig {
}
