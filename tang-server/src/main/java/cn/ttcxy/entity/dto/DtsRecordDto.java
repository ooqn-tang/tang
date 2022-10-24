package cn.ttcxy.entity.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsRecordDto {

  private String title;

  private String dataId;

  private String username;

  private String nickname;

  private Date createDate;

  private String type;
}
