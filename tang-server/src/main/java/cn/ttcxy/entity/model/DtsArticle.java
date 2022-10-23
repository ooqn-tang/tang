package cn.ttcxy.entity.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class DtsArticle {

    @Id
    private String articleId;

    private String title;

    @Column(updatable = false)
    private String authorId;

    @Column(updatable = false)
    private Date createDate;

    private Date updateDate;

    private Integer state;

    private String synopsis;

}