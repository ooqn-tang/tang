package net.ttcxy.tang.gateway.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@MapperScan(basePackages ={"net.ttcxy.tang.gateway.dao.mapper","net.ttcxy.tang.gateway.dao"})
@Component
public class MyBatisConfig {
}
