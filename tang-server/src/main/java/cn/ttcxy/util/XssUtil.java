package cn.ttcxy.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Document.OutputSettings.Syntax;
import org.jsoup.safety.Safelist;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class XssUtil {

    /**
     * 过滤掉xss字符串
     *
     * @param value
     * @return
     */
    public static String stripXss(String value) {
        Safelist whitelist = Safelist.relaxed();
        return Jsoup.clean(value,whitelist);
    }



    public static void main(String[] args) {
        
        String html = "{'asdf':'<p style=\"\">aaaaaaaaaaaaaaa</p>'}";//接收到的html代码
        JSONObject parseObject = JSONObject.parseObject(html);
        analysisJson(parseObject);

        System.out.println(parseObject);
    }

    public static void  analysisJson(Object objJson){
        //如果objJson为json数组
        if(objJson instanceof JSONArray) {
            JSONArray objArray = (JSONArray)objJson;
            for (int i = 0; i < objArray.size(); i++) {
                analysisJson(objArray.get(i));
            }
        } else if(objJson instanceof JSONObject) { //如果objJson为json对象
            JSONObject jsonObject = (JSONObject)objJson;
            Iterator it = jsonObject.keySet().iterator();
            while(it.hasNext()) {
                String key = it.next().toString();
                Object value = jsonObject.get(key); //value
                if(value instanceof JSONArray) { //如果value是数组
                    JSONArray objArray = (JSONArray)value;
                    analysisJson(objArray);
                } else if(value instanceof JSONObject){ //如果value是json对象
                    analysisJson((JSONObject)value);
                } else { //如果value是基本类型
                    jsonObject.put(key, stripXss((String)value));
                }
            }
        }
    }
}


