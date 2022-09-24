package cn.ttcxy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.hutool.core.util.StrUtil;

public class XssUtil {

    private static List<Pattern> patterns = null;

    /**
     * @return
     */
    private static List<Object[]> getXssPatternList() {
        List<Object[]> ret = new ArrayList<Object[]>();
        ret.add(new Object[] { "<(no)?script[^>]*>.*?</(no)?script>", Pattern.CASE_INSENSITIVE });
        ret.add(new Object[] { "eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        ret.add(new Object[] { "expression\\((.*?)\\)",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        ret.add(new Object[] { "javascript:|vbscript:|view-source:", Pattern.CASE_INSENSITIVE });
        ret.add(new Object[] { "<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        ret.add(new Object[] { "window\\.|\\.location|document\\.|alert\\(|window\\.open\\(",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        ret.add(new Object[] {
                "<+\\s*\\w*\\s*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|οnerrοr=|onerroupdate|onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|onstop|onsubmit|onunload)+\\s*=+",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL });
        return ret;
    }

    /**
     * @return
     */
    private static List<Pattern> getPatterns() {
        if (patterns == null) {
            List<Pattern> list = new ArrayList<Pattern>();
            String regex = null;
            Integer flag = null;

            for (Object[] arr : getXssPatternList()) {
                if (arr.length != 2) {
                    continue;
                }
                regex = (String) arr[0];
                flag = (Integer) arr[1];
                list.add(Pattern.compile(regex, flag));
            }
            patterns = list;
        }

        return patterns;
    }

    /**
     * 过滤掉xss字符串
     *
     * @param value
     * @return
     */
    public static String stripXss(String value) {
        if (!StrUtil.isEmpty(value)) {
            Matcher matcher = null;

            for (Pattern pattern : getPatterns()) {
                matcher = pattern.matcher(value);
                // 匹配
                if (matcher.find()) {
                    // 删除相关字符串
                    value = matcher.replaceAll("");
                }
            }
            value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        }
        return value;
    }

    /**
     * 是否存在xss
     *
     * @param value
     * @return
     */
    public static void checkXss(String value) {
        if (!StrUtil.isEmpty(value)) {
            Matcher matcher = null;

            for (Pattern pattern : getPatterns()) {
                matcher = pattern.matcher(value);
                // 匹配
                if (matcher.find()) {
                    System.out.print((String.format("存在非法字符［%s］", value)));
                }
            }

        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(stripXss("alert('asdfasdf')111111111111111"));
    }
}


