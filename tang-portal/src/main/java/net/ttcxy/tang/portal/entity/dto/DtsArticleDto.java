package net.ttcxy.tang.portal.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.ttcxy.tang.portal.entity.model.DtsArticleTag;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Article模型类
 * @author LYJ
 */
@Data
public class DtsArticleDto {

    private String articleId;

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

    // 标签列表
    private List<DtsArticleTag> tagList;

}
