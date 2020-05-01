/*
package net.ttcxy.tangtang;


import cn.hutool.core.comparator.ComparatorChain;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.PinyinUtil;
import cn.hutool.http.HttpUtil;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WxBot {

    public static void main(String[] args) throws IOException {

        */
/*String html = FileUtil.readString("C:\\Users\\Administrator\\Desktop\\方方评论.txt","utf-8");
        Elements es = Jsoup.parse(html).select(".m-text-box h3");
        System.out.println(es.size());

        es.forEach(a->{

            System.out.println(a.text());

        });*//*


        //getImage();

        //建立词频分析器，设置词频，以及词语最短长度，此处的参数配置视情况而定即可
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);

        //引入中文解析器
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
        //指定文本文件路径，生成词频集合
        final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load("C:\\Users\\Administrator\\Desktop\\3.txt");



        wordFrequencyList.forEach(a->{

            System.out.println(a.getWord()+"："+a.getFrequency());
        });
        //设置图片分辨率
        Dimension dimension = new Dimension(500,500);
        //此处的设置采用内置常量即可，生成词云对象
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        //设置边界及字体
        wordCloud.setPadding(2);
        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 200);
        //设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setKumoFont(new KumoFont(font));
        //设置背景色
        wordCloud.setBackgroundColor(new Color(255,255,255));
        //设置背景图片
        //wordCloud.setBackground(new PixelBoundryBackground("E:\\爬虫/google.jpg"));
        //设置背景图层为圆形
        //wordCloud.setBackground(new CircleBackground(50));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
        //生成词云
        wordCloud.build(wordFrequencyList);
        wordCloud.writeToFile("D:\\wy.png");

        */
/*FileUtil.file();




        System.out.println(es.size());*//*

       */
/* .forEach(action->{
            System.out.println(action.text());
        });*//*

    }

    //获取微博用户照片
    public static void getImage(){
        String html = FileUtil.readString("C:\\Users\\Administrator\\Desktop\\ssyy.txt","utf-8");
        Elements es = Jsoup.parse(html).select(".photo_pict");

        es.forEach(a->{

            //System.out.println(a.attr("src"));
            String ss = a.attr("src").replaceAll("//wxt.sinaimg.cn/thumb300/","").split("\\?")[0];

            String url = String.format("https://wx4.sinaimg.cn/mw1024/"+ss);
            System.out.println(url);
            File file = FileUtil.file(url);

            ThreadUtil.sleep(3000);
            try{
                HttpUtil.downloadFile(url,"C:\\Users\\Administrator\\Desktop\\ssyy\\"+ss);
            }catch (Exception e){
                System.out.println(url+"失败");
            }




            System.out.println(file.getName());



        });
    }



}*/
