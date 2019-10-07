package net.ttcxy.tangtang.entity.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 广告实体类
 */
@Data
public class AdvertiseParam {

    private String id;

    @NotNull
    private String title;

    @NotNull
    private String  url;

    private String createDate;

    private String deliveryTime;

    @NotNull
    private String description;

}
