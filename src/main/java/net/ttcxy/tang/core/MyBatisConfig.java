package net.ttcxy.tang.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@MapperScan(basePackages ={"net.ttcxy.tang.dao.mapper","net.ttcxy.tang.dao"})
@Component
public class MyBatisConfig {
}
