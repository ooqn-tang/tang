package com.jnnvc.vblog;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.jnnvc.vblog.mapper.BlogMapper;
import com.jnnvc.vblog.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class BvlogApplicationTests {





    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void contextLoads() throws IOException {

        for(int i =0 ; i<100;i++){
            String cookie = getCookie("http://fgw.sh.gov.cn/zfsp.htm");
        }
        System.out.println(ls);


        /*HttpRequest httpRequest = HttpRequest.post("http://fgw.sh.gov.cn/manager/JSON-RPC");
        httpRequest.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36");
        httpRequest.header("Cookie",cookie);
        httpRequest.header("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8");
        httpRequest.header("Accept-Encoding","gzip, deflate");
        httpRequest.header("Content-type","text/plain");
        httpRequest.body("{\"id\": 3, \"method\": \"ShPriceRPC.findZhuFuByParams\", \"params\": [\"meat\", \"_meat009_\", \"\", \"_county001002_\", \"2019-08-09\"]}");

        System.out.println( httpRequest.execute().body());*/

    }
    static List<String> ls = new ArrayList<>();

    public static synchronized String getCookie(String url){
        String cks = "";
        try {
            long time = System.currentTimeMillis();
            java.util.logging.Logger.getLogger("net.gargoylesoftware").setLevel(Level.FINER);
            java.util.logging.Logger.getLogger("org.apache.http").setLevel(Level.FINER);
            final WebClient webclient = new WebClient(BrowserVersion.FIREFOX_52);

            webclient.getOptions().setJavaScriptEnabled(true);
            webclient.getOptions().setThrowExceptionOnScriptError(true);
            webclient.getOptions().setCssEnabled(false);
            webclient.getCookieManager().clearCookies();
            webclient.getCache().clear();
            webclient.setRefreshHandler(new ImmediateRefreshHandler());
            webclient.getOptions().setTimeout(600*1000);
            webclient.setJavaScriptTimeout(600*1000);
            webclient.setAjaxController(new NicelyResynchronizingAjaxController());
            webclient.setJavaScriptTimeout(600*1000);
            webclient.getOptions().setRedirectEnabled(true);
            webclient.waitForBackgroundJavaScript(60*1000);
            webclient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webclient.getOptions().setUseInsecureSSL(true);
            final HtmlPage page = webclient.getPage(url);
            CookieManager CM = webclient.getCookieManager();
            Set<Cookie> cookies = CM.getCookies();//返回的Cookie在这里，下次请求的时候可能可以用上啦。

            for(Cookie c : cookies) {
                cks = cks+c.getName()+"="+c.getValue()+";";
            }
            webclient.close();
            if (!StrUtil.isEmpty(cks)) {
                System.out.println("获取cookie耗时："+(System.currentTimeMillis()-time));
                ls.add(""+(System.currentTimeMillis()-time));
            }else {
                System.out.println("*******获取cookie失败，耗时："+(System.currentTimeMillis()-time)+"******");
            }
        } catch (Exception e) {
            System.out.println("通过htmlunit获取cookie失败......");
            System.out.println(e);
        }
        return cks;
    }

}
