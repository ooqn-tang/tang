package cn.ttcxy;

import cn.hutool.db.nosql.redis.RedisDS;
import cn.hutool.setting.Setting;
import cn.ttcxy.mapper.dao.DtsArticleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class TangApplicationTests {

	@Autowired
	DtsArticleDao dtsArticleDao;

	@Test
	void contextLoads() {
		System.out.println(dtsArticleDao.selectArticleById(""));
	}

	public static void main(String[] args) {
		RedisDS redisDS = RedisDS.create();

		redisDS.setStr("test","asdfasdf");

		System.out.println(redisDS.getStr("test"));
	}
}
