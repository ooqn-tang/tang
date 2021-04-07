import cn.hutool.core.util.StrUtil;
import net.ttcxy.tang.gateway.TangApplication;
import net.ttcxy.tang.gateway.dao.DtsBlogDao;
import net.ttcxy.tang.mapper.DtsBlogMapper;
import net.ttcxy.tang.model.DtsBlog;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huanglei
 */

public class TestMain {

    @Autowired
    DtsBlogDao dtsBlogDao;

    @Autowired
    DtsBlogMapper dtsBlogMapper;

}
