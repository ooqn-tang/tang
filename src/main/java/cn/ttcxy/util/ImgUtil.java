package cn.ttcxy.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * 图片工具
 */
public class ImgUtil {
    public static boolean isNotImage(InputStream inputStream){
        try {
            BufferedImage read = ImageIO.read(inputStream);
            return read == null;
        } catch (IOException e) {
            return true;
        }
    }
}
