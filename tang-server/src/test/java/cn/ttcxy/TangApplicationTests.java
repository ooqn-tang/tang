package cn.ttcxy;

import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.repository.DtsEssayRepository;
import com.alibaba.fastjson.JSON;
import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import cn.ttcxy.repository.UtsRoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

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

    @Autowired
    DtsEssayRepository essayRepository;

    @Test
    public void test1(){
        DtsEssay essay = new DtsEssay();
        essay.setEssayId("1");
        essay.setText("sdjklfjkd");
        essay.setType("1");
        essay.setUrl("sdklfjklasdf");
        essay.setAuthorId("1");
        essay.setCreateTime(new Date());
        DtsEssay save = essayRepository.save(essay);
        System.out.println("===========");
        System.out.println(save);
        Pageable pageable = PageRequest.of(1, 30);
        Page<DtsEssayDto> select = essayRepository.findAllInfo(pageable);
        List<DtsEssayDto> content = select.getContent();
        System.out.println(JSON.toJSONString(content));
    }
}
