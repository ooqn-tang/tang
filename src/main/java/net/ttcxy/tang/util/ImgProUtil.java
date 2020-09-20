package net.ttcxy.tang.util;

import cn.hutool.core.img.ImgUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * created by HuangLei on 2020/9/15
 */
public class ImgProUtil {
    public static boolean isNotImage(InputStream inputStream){
        try {
            BufferedImage read = ImageIO.read(inputStream);
            return read == null;
        } catch (IOException e) {
            return true;
        }
    }
}
