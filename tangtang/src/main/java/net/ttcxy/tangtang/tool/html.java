package net.ttcxy.tangtang.tool;

import cn.hutool.core.io.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class html {

    /**
     * 处理QQ群加入时间和发言时间一致的用户
     * @param args
     */
    public static void main(String[] args) {
        String string = FileUtil.readString("C:\\Users\\Administrator\\Desktop\\12.txt", "utf-8");

        Document parse = Jsoup.parse(string);
        Elements td = parse.select("tr");

        System.out.println(td.size());
        List<String> ls = new ArrayList<>();
        for(Element element : td){
            List<String> list = new ArrayList();

            for (Element element1 : element.select("td")){
                list.add(element1.text());
            }
            if (list.size()==11){
                if (list.get(7).equals(list.get(9))) {
                    System.out.println(String.format("QQ号：%s ， 加入时间：%s ， 最后说话时间：%s", list.get(4), list.get(7), list.get(9)));
                }
            }
        }

        System.out.println(ls);
    }
}
