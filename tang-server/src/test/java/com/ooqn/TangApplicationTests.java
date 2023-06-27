package com.ooqn;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ooqn.controller.DtsEssayController;
import com.ooqn.repository.DtsArticleRepository;
import com.ooqn.repository.DtsEssayRepository;
import com.ooqn.repository.UtsAuthorRepository;
import com.ooqn.repository.UtsRoleRepository;

@Configuration
@SpringBootTest(classes = TangApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TangApplicationTests {

    @Autowired
    DtsEssayRepository essayRepository;
    
    @Test
    public void test1(){
        Pageable pageable = PageRequest.of(1, 10);
        System.out.println(essayRepository.findAll(pageable));
    }
}
