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
public class TextUtil2 {



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
        List<String> readLines = FileUtil.readLines("C:\\Users\\Administrator\\Desktop\\d.txt", "UTF-8");
        List<Map<String,String>> maps = new ArrayList<>();
        readLines.forEach(s -> {
            Map<String,String> map = new HashMap<>();
            map.put("original", JSONObject.parseObject(s).getJSONArray("trans_result").getJSONObject(0).getString("src"));
            map.put("translation", JSONObject.parseObject(s).getJSONArray("trans_result").getJSONObject(0).getString("dst"));
            maps.add(map);
            System.out.println(JSONObject.parseObject(s).getJSONArray("trans_result").getJSONObject(0).getString("src") + "：" + JSONObject.parseObject(s).getJSONArray("trans_result").getJSONObject(0).getString("dst"));
        });
        FileUtil.writeUtf8String(JSONObject.toJSONString(maps), "C:\\Users\\Administrator\\Desktop\\j.json");
    }
}
