package cn.ttcxy;

import javax.persistence.EntityManager;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.repository.dsl.UtsRoleDsl;

@Configuration
@SpringBootTest(classes = TangApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TangApplicationTests {

    @Bean
    @Autowired
    JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

	// 声明一个Autowired注解，表示它是一个自动注入的注解
	@Autowired
	UtsRoleDsl roleDsl;

	@BeforeAll
    public static void before(){
        try {
            Server.main("-tcp", "-tcpAllowOthers","-ifNotExists");
        } catch (Exception throwables) {
            System.err.println("数据库启动失败！");
            System.exit(-1);
        }
    }

	@Test
	public void test1(){
        System.out.println("=========================================");
		System.out.println(roleDsl.findByRoleName("admin"));
	}
}
