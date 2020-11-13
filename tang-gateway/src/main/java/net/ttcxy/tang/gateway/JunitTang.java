package net.ttcxy.tang.gateway;

import cn.hutool.json.JSONUtil;
import net.ttcxy.tang.gateway.dao.ResourceDao;
import net.ttcxy.tang.gateway.dao.RoleDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTang {

    @Autowired
    ResourceDao resourceDao;

    @Autowired
    RoleDao roleDao;

    @Test
    public void doTest() {
        System.out.println(JSONUtil.toJsonStr(roleDao.selectRoleListByAuthorId("c894e7a08bf041e985876d31b3977141")));
    }
}