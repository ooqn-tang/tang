package cn.ttcxy;

import javax.persistence.EntityManager;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.dao.dsl.UtsRoleDsl;

@SpringBootTest(classes = TangApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TangApplicationTests {

	@Bean
    @Autowired
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

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
