package com.jnnvc.vblog.utils;

/**
 * 参数工具
 */
public class ParamUtil {

    /**
     * 判断传入的参数是否有为空的
     * @param object
     * @return
     */
    public static boolean isNullParams(Object ...object){
        for (Object obj : object){
            if(obj==null)
                return true;
        }
        return false;
    }
}
