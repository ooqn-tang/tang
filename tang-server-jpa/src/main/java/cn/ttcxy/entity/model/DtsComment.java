package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class DtsComment {
    
    @Id
    private String commentId;

    private String dataId;

    private String parentCommentId;

    private String authorId;

    private String text;

    private Date createDate;

    private Integer state;

    private String type;

}