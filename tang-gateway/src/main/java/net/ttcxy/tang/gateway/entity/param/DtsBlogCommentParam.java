package net.ttcxy.tang.gateway.entity.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.ttcxy.tang.gateway.core.verify.VerifyAbstract;
import net.ttcxy.tang.gateway.entity.model.DtsBlog;
import net.ttcxy.tang.gateway.entity.model.DtsBlogComment;

import java.util.Date;

/**
 * 博客参数
 * @author huanglei
 */
@Data
public class DtsBlogCommentParam {

    private String blogCommentId;

    private String blogId;

    private String content;

}