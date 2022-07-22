package cn.ttcxy.entity.param;

import lombok.Data;

import java.util.List;

@Data
public class DtsCommentParam {

    private String commentId;

    private String dataId;

    private String parentCommentId;

    private String text;

    private Integer state;

    private String type;

    private List<String> atAuthorId;

}
