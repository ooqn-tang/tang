package cn.ttcxy.entity.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Article模型类
 */
@Getter
@Setter
public class DtsDataDto {

    private String dataId;

    // 用户名
    private String username;

    // 昵称
    private String nickname;

    // 博客标题
    private String title;

    // 创建时间
    private Date createDate;

    // 更新时间
    private Date updateDate;

    // 大纲
    private String synopsis;

    // 博文文本
    private String text;

    // markdown
    private String markdown;

    // 专题名
    private String subjectName;

    // 专题ID
    private String subjectId;

    private String type;


}
