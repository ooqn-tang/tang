package cn.ttcxy.entity.param;

import lombok.Data;

@Data
public class DtsTagParam {

    private String articleTagId;

    // 标签名
    private String tagName;

    // 描述
    private String synopsis;
}
