package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class DtsArticleSubject {
    
    @Id
    private String subjectId;

    private String subjectName;

    private String authorId;

    private Integer orderNum;

    private Date createDate;

    private Date updateDate;

    private String synopsis;

}