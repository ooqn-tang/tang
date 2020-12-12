import net.ttcxy.tang.admin.AdminApplication;
import net.ttcxy.tang.admin.service.StsMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huanglei
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class TestMain {

    @Autowired
    private StsMailService stsMailService;

    @Test
    public void test1(){
        System.out.println(stsMailService.sendMail("792190997@qq.com","test","test"));
    }
}
