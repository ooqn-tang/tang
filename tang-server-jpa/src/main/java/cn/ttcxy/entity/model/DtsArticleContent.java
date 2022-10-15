package cn.ttcxy.entity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DtsArticleContent {
    
    @Id
    private String articleId;

    private String text;

    private String markdown;

}