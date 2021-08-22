package net.ttcxy.tang.portal.entity.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 博客参数
 * @author huanglei
 */
@Data
public class DtsCommentParam {

    // 博客评论ID")
    private String commentId;

    // 博客ID")
    @NotBlank(message = "评论不能为空")
    private String dataId;

    // 评论内容")
    @Length(min = 1,max = 250,message = "请正确输入内容")
    private String content;

}