package cn.ttcxy;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.mapper.dsl.DtsClassDsl;

@SpringBootTest(classes = TangApplication.class)
class TangApplicationTests {

	public static void main(String[] args) {
		
	}

	@Bean
    @Autowired
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

	@Autowired
	DtsClassDsl classDsl;

	@Test
	public void test1(){
		System.out.println(classDsl.selectClass("1"));
	}
}
