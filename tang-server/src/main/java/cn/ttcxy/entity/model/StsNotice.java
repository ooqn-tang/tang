package cn.ttcxy.entity.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class StsNotice {

  @Id
  private String noticeId;

  private String title;

  private String url;

  private Date createDate;

  private String description;

  private Integer orderNum;
}
