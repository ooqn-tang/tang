package net.ttcxy.tang.gateway.core.verify;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;

public abstract class VerifyEntity {

    public void createVerify() throws Exception {
        throw new Exception("没有重写 create 验证器");
    }

    public void updateVerify() throws Exception {
        throw new Exception("没有重写 update 验证器");
    }

    public void selectVerify() throws Exception {
        throw new Exception("没有重写 select 验证器");
    }

    public void deleteVerify() throws Exception {
        throw new Exception("没有重写 delete 验证器");
    }

    /**
     * 非空
     * @param item 需要验证的值
     * @param message 验证不通过，显示的异常
     */
    public static void notNull(String item,String message) throws Exception {
        if (item == null){
            throw new Exception(message);
        }
    }

    /**
     * 字符串通过正则表达式验证 ， 为null时跳转验证，请先调用notNull
     * @param item 验证的值
     * @param reg 正则表达式字符串
     * @param message 异常消息
     */
    public static void verify(String item,String reg,String message) throws Exception {
        if (ReUtil.isMatch(item,reg)){
            throw new Exception(message);
        }
    }

    /**
     * 验证最大值 ， 为null时跳转验证，请先调用notNull
     * @param item 验证的值
     * @param maxLen 字符串最大长度
     * @param message 异常消息
     */
    public static void maxLen(String item,Integer maxLen,String message) throws Exception {
        if (StrUtil.length(item) > maxLen){
            throw new Exception(message);
        }
    }

    /**
     * 验证字符串最短长度 , 为null时跳转验证，请先调用notNull
     * @param item 验证的值
     * @param mixLen 最小长度
     * @param message 异常消息
     */
    public static void mixLen(String item,Integer mixLen,String message) throws Exception {
        if (StrUtil.length(item) < mixLen){
            throw new Exception(message);
        }
    }

    /**
     * 大小之间 ， 为null时跳转验证，请先调用notNull
     * @param item 验证的值
     * @param mixLen 最小值
     * @param maxLen 最大值
     * @param message 异常消息
     */
    public static void mixAndMaxLen(String item,Integer mixLen,Integer maxLen,String message) throws Exception {
        int length = StrUtil.length(item);
        if (length < maxLen && length > mixLen){
            throw new Exception(message);
        }
    }

    /**
     * 最大数值大小
     * @param item 验证的值
     * @param maxSize 最大值（对于）
     * @param message 异常消息
     */
    public static void maxSize(Number item,Number maxSize,String message){

    }

    /**
     * 最小数值
     * @param item 验证的值
     * @param mixSize 最小值
     * @param message 异常消息
     */
    public static void mixSize(Number item,Number mixSize,String message){}

    /**
     * 数字在之间
     * @param item 验证的值
     * @param maxSize 最大值
     * @param message 异常消息
     */
    public static void mixMaxBetween(Number item,Number maxSize,String message){}
}
