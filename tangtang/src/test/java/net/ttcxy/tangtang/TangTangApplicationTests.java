package net.ttcxy.tangtang;

import net.ttcxy.tangtang.dao.CommentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TangTangApplicationTests {


    @Autowired
    CommentDao commentDao;

    @Test
    public void contextLoads() throws IOException {

        System.out.println(commentDao.selectComment("26c0fd33c3a34ee2abdc7b545e9cb287"));;


       /* CommentDto comment = new CommentDto();
        comment.setId(IdUtil.fastSimpleUUID());
        comment.setBlogId("1");
        comment.setContent("asdf");
        comment.setCreateDate(new Date());
        comment.setStatus("1");
        comment.setUserId("11");

        System.out.println(commentDao.insertComment(comment));*/
        //System.out.println(JSON.toJSONString(specialMapper.selectSpecial()));

    }

}
