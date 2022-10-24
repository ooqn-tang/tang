package cn.ttcxy.util;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class XssUtil {

  /**
   * 过滤掉xss字符串
   *
   * @param value
   * @return
   */
  public static String stripXss(String value) {
    Safelist whitelist = Safelist.relaxed();
    return Jsoup.clean(value, whitelist);
  }

  public static void main(String[] args) {
    String html = "{'asdf':'<p style=\"\">aaaaaaaaaaaaaaa</p>'}"; // 接收到的html代码
    JSONObject parseObject = JSONObject.parseObject(html);
    System.out.println(parseObject);
  }
}
