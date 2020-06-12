package net.ttcxy.tang.util;

import net.ttcxy.tang.util.exception.RegexMapException;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * 正则表达式链
 * @author Administrator
 */
public class RegexMapUtil {
    public static void check(String regex, Map<String,String> regexMap) throws RegexMapException {
        if (regexMap == null){
            throw new NullPointerException("RegexMapUtil.check.regexMap");
        }
        for (Map.Entry<String,String> me : regexMap.entrySet()){
            if (!Pattern.matches(me.getKey(),regex)){
                throw new RegexMapException(me.getValue());
            }
        }
    }
}
