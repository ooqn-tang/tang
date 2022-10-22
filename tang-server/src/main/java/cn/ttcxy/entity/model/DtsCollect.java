package cn.ttcxy.entity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DtsCollect {
    
    @Id
    private String collectId;

    private String authorId;

    private String dataId;

    private Date createDate;

    private Integer type;

}