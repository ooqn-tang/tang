package net.ttcxy.tang.entity.dto;

import lombok.Data;

@Data
public class MailVerifyDto {
    private String mail;

    private String code;

    public MailVerifyDto(String mail, String code) {
        this.mail = mail;
        this.code = code;
    }
}
