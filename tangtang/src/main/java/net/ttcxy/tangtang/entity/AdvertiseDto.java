package net.ttcxy.tangtang.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 广告实体类
 * @author huanglei
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AdvertiseDto {

    private String id;

    private String title;

    private String  url;

    private String createDate;

    private String deliveryTime;

    private String description;

}
