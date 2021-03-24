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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TangApplication.class)
public class TestMain {

    @Autowired
    DtsBlogDao dtsBlogDao;

    @Autowired
    DtsBlogMapper dtsBlogMapper;

    @Test
    public void upateMs(){
        while(true){
            try{
                DtsBlog dtsBlog = dtsBlogDao.selectBlogMsIsNull();
                System.out.println(dtsBlog);

                String text = dtsBlog.getText();
                if (text == null) {
                    dtsBlog.setSynopsis(" ");;

                    dtsBlogMapper.updateByPrimaryKeySelective(dtsBlog);
                    continue;
                };
                text = Jsoup.parse(text).text();
                String ms = StrUtil.sub(text,0,250).replaceAll("\n","");

                if (ms.equals("")){
                    dtsBlog.setSynopsis(" ");;
                    dtsBlogMapper.updateByPrimaryKeySelective(dtsBlog);
                    continue;
                }
                dtsBlog.setSynopsis(ms);
                dtsBlogMapper.updateByPrimaryKeySelective(dtsBlog);
            }catch (Exception e){

            }
        }
    }
}
