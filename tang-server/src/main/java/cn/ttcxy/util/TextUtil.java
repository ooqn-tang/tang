package cn.ttcxy.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpUtil;

/**
 * String util pro 对String操作的其他方法
 */
public class TextUtil {



    /**
     * 获取字符串的字节数
     * @param string 输入字符串
     * @return 字节数
     */
    public static int byteSize(String string){
        int length = 0;
        for (int i = 0; i < string.length(); i++) {
            int ascii = Character.codePointAt(string, i);
            if (ascii >= 0 && ascii <= 255) {
                length++;
            } else {
                length += 2;
            }
        }

        return length;
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> readUtf8Lines = FileUtil.readUtf8Lines("C:\\Users\\Administrator\\Desktop\\the.a");
        List<String> list = new ArrayList<>();
        for (String string : readUtf8Lines) {
            if(!string.trim().equals("")){
                String salt = String.valueOf(System.currentTimeMillis());
                Map<String, Object> map = new HashMap<>();
                map.put("q", string.trim());
                map.put("from", "en");
                map.put("to", "zh");
                map.put("appid", "20220821001314900");
                map.put("salt", salt);
                map.put("sign", DigestUtil.md5Hex("20220821001314900" + string.trim() + salt + "FcRfYReX9rogOY6S17VY"));
                String string2 = HttpUtil.get("https://fanyi-api.baidu.com/api/trans/vip/translate",map);
                list.add(string2);
                Thread.sleep(2000);
                System.out.println(string2);
            }
        }
        FileUtil.writeUtf8Lines(list, "C:\\Users\\Administrator\\Desktop\\d.txt");
    }
}
