package cn.ttcxy;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import cn.ttcxy.repository.UtsRoleRepository;

@Configuration
@SpringBootTest(classes = TangApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TangApplicationTests {

	@BeforeAll
    public static void before(){
        try {
            Server.main("-tcp", "-tcpAllowOthers","-ifNotExists");
        } catch (Exception throwables) {
            System.err.println("数据库启动失败！");
            System.exit(-1);
        }
    }

    @Autowired
    UtsRoleRepository utsRoleRepository;

	@Test
	public void test1(){
        System.out.println("kaskdfjkalsjdflkd");
        System.out.println(utsRoleRepository.count());
	}
}
