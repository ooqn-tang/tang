package cn.ttcxy.entity.dto;

import java.util.Date;
import java.util.List;

import cn.ttcxy.entity.model.DtsArticle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsArticleSubjectDto {

    private String subjectId;

    // 专题名
    private String subjectName;

    // 描述
    private String synopsis;

    // 创建时间
    private Date createDate;

    // 更新时间
    private Date updateDate;

    private String authorId;

    private String username;

    private String nickname;

    // 博客列表
    private List<DtsArticle> articleList;
}
