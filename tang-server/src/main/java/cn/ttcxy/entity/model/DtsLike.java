package cn.ttcxy.entity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DtsLike {
    
    @Id
    private String likeId;

    private String dataId;

    private String authorId;

    private Date createTime;

}