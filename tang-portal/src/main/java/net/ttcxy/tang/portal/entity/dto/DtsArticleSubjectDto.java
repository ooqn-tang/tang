package net.ttcxy.tang.portal.entity.dto;

import lombok.Data;
import net.ttcxy.tang.portal.entity.model.DtsArticle;

import java.util.Date;
import java.util.List;

@Data
public class DtsArticleSubjectDto {

    private String articleSubjectId;

    // 专题名")
    private String subjectName;

    // 描述")
    private String synopsis;

    // 创建时间")
    private Date createDate;

    // 更新时间")
    private Date updateDate;

    private String authorId;

    private String username;

    private String nickname;

    // 博客列表")
    private List<DtsArticle> articleList;
}
