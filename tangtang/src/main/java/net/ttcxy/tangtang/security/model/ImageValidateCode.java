package net.ttcxy.tangtang.security.model;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author ：HuangLei
 * @date ：2019/11/25 0025 21:09
 */
public class ImageValidateCode extends ValidateCode {

    private BufferedImage image;

    public ImageValidateCode(BufferedImage image , String code, LocalDateTime localDateTime){
        super(code,localDateTime);
        this.image = image;
    }

    public ImageValidateCode(BufferedImage image , String code, int localDateTime){
        super(code,localDateTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
