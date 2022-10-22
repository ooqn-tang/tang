package cn.ttcxy.entity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DtsArticle {

    @Id
    private String articleId;

    private String title;

    private String authorId;

    private Date createDate;

    private Date updateDate;

    private Integer state;

    private String synopsis;

    private String subjectId;

    private String orderNum;

}