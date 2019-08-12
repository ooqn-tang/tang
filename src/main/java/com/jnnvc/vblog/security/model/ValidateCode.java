package com.jnnvc.vblog.security.model;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ValidateCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime localDateTime;

    /**
     * ValidateCode
     * @param image 图片Buffered
     * @param code 验证码
     * @param expireIn 验证码有效秒数
     */
    public ValidateCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.localDateTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    /**
     *
     * @param image 图片Buffered
     * @param code 验证码
     * @param localDateTime 过期时间
     */
    public ValidateCode(BufferedImage image, String code, LocalDateTime localDateTime) {
        this.image = image;
        this.code = code;
        this.localDateTime = localDateTime;
    }

    public boolean isExpried(){
        return LocalDateTime.now().isAfter(localDateTime);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
