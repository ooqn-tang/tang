import net.ttcxy.tang.gateway.dao.DtsBlogDao;
import net.ttcxy.tang.gateway.mapper.DtsBlogMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huanglei
 */
public class TestMain {

    @Autowired
    DtsBlogDao dtsBlogDao;

    @Autowired
    DtsBlogMapper dtsBlogMapper;

}
