package net.ttcxy.tangtang.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：huanglei
 * @date ：2020/4/10 0010 19:52
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FansDto {

    private String id;

    private String userId;

    private String follower;

    private String nickname;

    private String username;

    private Date createDate;

}
