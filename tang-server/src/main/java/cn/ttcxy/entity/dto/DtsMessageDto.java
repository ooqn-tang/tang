package cn.ttcxy.entity.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsMessageDto {

  private String messageId;

  private String authorId;

  private Date createDate;

  private String text;

  private String title;

  private String username;

  private String url;

  private String nickname;
}
