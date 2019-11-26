package net.ttcxy.tangtang.security.model;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ValidateCode {

    private String code;

    private LocalDateTime localDateTime;

    public ValidateCode(String code, LocalDateTime localDateTime) {
        this.code = code;
        this.localDateTime = localDateTime;
    }

    public ValidateCode(String code, int localDateTime) {
        this.code = code;
        this.localDateTime = LocalDateTime.now().plusSeconds(localDateTime);
    }




    public boolean isExpried(){
        return LocalDateTime.now().isAfter(localDateTime);
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
