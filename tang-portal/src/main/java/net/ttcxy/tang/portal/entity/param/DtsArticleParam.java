package net.ttcxy.tang.portal.entity.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author LYJ
 */
@Data
public class DtsArticleParam {

    private String articleId;

    // 博客标题")
    @NotBlank
    @Length(min = 1, max = 150, message = "长度在1 ~ 150之间")
    private String title;

    // 描述")
    @NotBlank
    @Length(min = 1, max = 200, message = "长度在1 ~ 200之间")
    private String synopsis;

    // 博文文本")
    @NotBlank
    private String text;

    // markdown")
    @NotBlank
    private String markdown;

    // 专题ID")
    private String subjectId;

    // 标签ID列表")
    @Size(max = 3, message = "标签数量不能超过3个")
    private List<String> tagIdList;
}
