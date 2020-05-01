package net.ttcxy.tangtang;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.http.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：HuangLei
 * @date ：2020/4/19 0019 13:01
 */
public class AutoWeibo {

    public static void main(String[] args) throws InterruptedException, IOException {


        //send();

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");//指定驱动路径

        WebDriver driver =new ChromeDriver();

        Dimension dimension = new Dimension(400, 800);
        driver.manage().window().setSize(dimension);

        driver.get("https://m.weibo.cn/u/1222425514");
        ThreadUtil.sleep(3000);

        Elements elements = Jsoup.parse(driver.getPageSource()).select(".weibo-text");

        for (Element element:elements) {
            ls.add(element.text());
        }

       while(true){
           ThreadUtil.sleep(10000);
           driver.get("https://m.weibo.cn/u/1222425514");

           ThreadUtil.sleep(3000);
           Elements e = Jsoup.parse(driver.getPageSource()).select(".weibo-text");
            for (Element element:e) {
                System.out.println(element.text());
                if (!ls.contains(element.text())){
                    ls.add(element.text());
                    send();
                }else{

                }
            }


        }







    }


    public static void send(){
        WebDriver driver = null;
        try{
            String[] text = {"有些人听到一些风言风语就背叛了方方，为什么？",
                    "无论你是“方孝子”，还是“碍国者”，第一时间评论都显得格外重要","为了你们的信仰战斗吧","评论了一条相对中立的评论，被方孝子和碍国者骂的不行","人一旦吃饱了后果不堪设想","谁是正确的？你们评评理？","我第一，给我点赞，评论，加关注","怀念你们追星，努力为每天吃什么奋斗的日子","富强、民主、文明、和谐，自由、平等、公正、法治，爱国、敬业、诚信、友善。你们两方都做不到","没事多看看书，不要刷微博了"};
            int integer = RandomUtil.randomInt(9);
            String testString = text[integer];


            System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");//指定驱动路径

            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
            driver =new ChromeDriver(options);

            Dimension dimension = new Dimension(400, 600);
            driver.manage().window().setSize(dimension);

            //get 到百度首页
            driver.get("https://m.weibo.cn/u/1222425514");

            ThreadUtil.sleep(2000);
            ((ChromeDriver) driver).executeScript("document.querySelector(\"#app > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div > div > article > div > div.weibo-text\").click()"); //鼠标左键点击指定的元素对象
            ThreadUtil.sleep(2000);
            ((ChromeDriver) driver).findElementByXPath("/html/body/div/div[1]/div/div[5]/div/div[1]/span").click();
            ThreadUtil.sleep(2000);
            ((ChromeDriver) driver).findElementByXPath("/html/body/div/div[1]/div/div[5]/div/div/div/div[1]").click();
            ThreadUtil.sleep(1000);
            ((ChromeDriver) driver).findElementByXPath("/html/body/div/div[1]/div/div[5]/div/div/div/div[1]/textarea[1]").sendKeys(testString);
            ThreadUtil.sleep(1000);
            ((ChromeDriver) driver).findElementByXPath("/html/body/div/div[1]/div/div[5]/div/div/div/div[2]/button").click();
            ThreadUtil.sleep(1000);
            Elements elements = Jsoup.parse(driver.getPageSource()).select(".weibo-text");

            for (Element element:elements) {
                ls.add(element.text());
            }


        }catch (Exception e){

            e.printStackTrace();
        }finally {
            if (driver!=null){
                driver.quit();
            }
        }



    }

    static List<String> ls = new ArrayList<>();
}
