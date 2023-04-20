package com.ooqn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import com.ooqn.repository.DtsArticleRepository;
import com.ooqn.repository.DtsEssayRepository;
import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;

import com.ooqn.entity.dto.DtsEssayDto;
import com.ooqn.entity.model.DtsEssay;
import com.ooqn.repository.UtsRoleRepository;

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
    DtsArticleRepository articleRepository;

    @Test
    public void test1(){

    }
}
