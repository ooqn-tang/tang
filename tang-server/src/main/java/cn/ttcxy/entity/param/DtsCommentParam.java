package cn.ttcxy.entity.param;

import java.util.List;
import lombok.Data;

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
