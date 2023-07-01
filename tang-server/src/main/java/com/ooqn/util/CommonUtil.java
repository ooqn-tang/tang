package com.ooqn.util;

public class CommonUtil {
    // html删除标签
    public static String delHTMLTag(String htmlStr) {
        // 定义script的正则表达式
        String regExScript = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        // 定义style的正则表达式
        String regExStyle = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        // 定义HTML标签的正则表达式
        String regExHtml = "<[^>]+>";
        // 定义空格回车换行符
        String regExSpace = "\\s*|\t|\r|\n";
        // 过滤script标签
        htmlStr = htmlStr.replaceAll(regExScript, "");
        // 过滤style标签
        htmlStr = htmlStr.replaceAll(regExStyle, "");
        // 过滤html标签
        htmlStr = htmlStr.replaceAll(regExHtml, "");
        // 过滤空格回车标签
        htmlStr = htmlStr.replaceAll(regExSpace, "");
        return htmlStr.trim(); // 返回文本字符串
    }
}
