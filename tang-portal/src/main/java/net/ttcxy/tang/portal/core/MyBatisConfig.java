package net.ttcxy.tang.portal.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author huanglei
 */
@MapperScan(basePackages ={"net.ttcxy.tang.portal.dao.mapper","net.ttcxy.tang.portal.dao"})
@Component
public class MyBatisConfig {
}
