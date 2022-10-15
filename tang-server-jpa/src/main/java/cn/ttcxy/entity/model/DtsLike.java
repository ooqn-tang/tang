package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class DtsLike {
    
    @Id
    private String likeId;

    private String dataId;

    private String authorId;

    private Date createTime;

}