package net.ttcxy.tang.gateway.entity.param;

import lombok.Data;

/**
 * @author huanglei
 */
@Data
public class UtsAuthorUpdateParam {

    private String authorId;

    private String username;

    private String nickname;

    private String mail;

    private String signature;

}