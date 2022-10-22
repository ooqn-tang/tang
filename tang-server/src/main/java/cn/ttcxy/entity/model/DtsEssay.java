package cn.ttcxy.entity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DtsEssay {
    
    @Id
    private String essayId;

    private String authorId;

    private String text;

    private String url;

    private Date createTime;

    private String coverUrl;

    private String type;

}