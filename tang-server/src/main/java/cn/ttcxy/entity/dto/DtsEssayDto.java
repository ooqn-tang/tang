package cn.ttcxy.entity.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsEssayDto {

  private String essayId;

  private String authorId;

  private String text;

  private String url;

  private Date createTime;

  private String coverUrl;

  private String nickname;

  private String username;
}
