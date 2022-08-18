package cn.ttcxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.hutool.db.nosql.redis.RedisDS;
import cn.ttcxy.mapper.dao.DtsArticleDao;

@SpringBootTest
class TangApplicationTests {

	@Autowired
	DtsArticleDao dtsArticleDao;

	@Test
	void contextLoads() {
		dtsArticleDao.selectArticleById("");
	}

	public static void main(String[] args) {
		RedisDS redisDS = RedisDS.create();
		redisDS.setStr("test","asdfasdf");
		System.out.println(redisDS.getStr("test"));
	}
}
