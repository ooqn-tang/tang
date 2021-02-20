import net.ttcxy.tang.admin.service.StsMailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huanglei
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AdminApplication.class)
public class TestMain {

    @Autowired
    private StsMailService stsMailService;

    //@Test
    public void test1(){
        System.out.println(stsMailService.sendMail("792190997@qq.com","test","test"));
    }


    @Autowired
    DtsBlogMapper blogMapper;
    public void upateMs(){
        DtsBlogExample blogExample = new DtsBlogExample();
        blogExample.createCriteria().andSynopsisEqualTo("");
    }
}
