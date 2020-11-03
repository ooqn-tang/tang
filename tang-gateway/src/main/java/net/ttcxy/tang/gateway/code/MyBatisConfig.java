package net.ttcxy.tang.gateway.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@MapperScan(basePackages ={"net.ttcxy.tang.mapper","net.ttcxy.tang.gateway.dao"})
@Component
public class MyBatisConfig {
}
