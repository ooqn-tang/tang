package cn.ttcxy.entity.param;

import lombok.Data;

import java.util.Date;

@Data
public class UtsResourceParam {

    private String resourceId;

    private String path;

    private String name;

    private String type;

    private Date createTime;
}
