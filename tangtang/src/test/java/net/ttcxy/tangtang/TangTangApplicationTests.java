package net.ttcxy.tangtang;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import net.ttcxy.tangtang.entity.Pageview;
import net.ttcxy.tangtang.mapper.BlogMapper;
import net.ttcxy.tangtang.mapper.PageviewMapper;
import net.ttcxy.tangtang.mapper.SpecialMapper;
import net.ttcxy.tangtang.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TangTangApplicationTests {


    @Autowired
    SpecialMapper specialMapper;
    @Test
    public void contextLoads() throws IOException {

        //System.out.println(JSON.toJSONString(specialMapper.selectSpecial()));

    }

}
