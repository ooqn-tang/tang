package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

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