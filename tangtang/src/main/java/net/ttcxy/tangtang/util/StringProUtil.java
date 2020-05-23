package net.ttcxy.tangtang.util;

/**
 * String util pro
 * @author huanglei
 */
public class StringProUtil {

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
}
