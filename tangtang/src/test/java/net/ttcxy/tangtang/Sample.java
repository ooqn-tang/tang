package net.ttcxy.tangtang;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author ：HuangLei
 * @date ：2019/10/6 0006 21:19
 */
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "16633386";
    public static final String API_KEY = "VPOrOfCcVQpEtqCI69RI9saS";
    public static final String SECRET_KEY = "8D16XtGFIxeg12hAW4ptyf2ZnkzzkWul";

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        TtsResponse res = client.synthesis("拖延半年之久的计划，今天终于开始了，没错，这便是运作一个自己的公众号。 而我将从读书日记开始写自己的“文章”，当然我现在写的东西应该也称不上文章二字，只能说是一些自己内心感受吧。\n" +
                "\n" +
                "而我在做这么一件事情前期便有多次与朋友说出了我内心的想法啊，而他们纷纷劝说道，你有这时间为什么不好好学习专业知识，说不定将来还能成为一名大拿呢，何必把时间花在这毫无意义的事情上呢？即使有着众多的悲观声，也无法左右我的决定了，因为在我内心深处早已作出了它自己的选择。\n" +
                "\n" +
                "竟然已经到了这一步，接下来就是要知道公众号的定位了，经过多方面分析与琢磨最终我决定从读书笔记开始出发，选择这样一种方式是因为不让自己陷入一个无题可写的底部吧。\n", "zh", 1, null);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, "output.mp3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }

    }
}
