package cn.ttcxy;

import cn.ttcxy.mapper.dao.DtsArticleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TangApplicationTests {

	@Autowired
	DtsArticleDao dtsArticleDao;

	@Test
	void contextLoads() {
		System.out.println(dtsArticleDao.selectArticleById(""));
	}

}
