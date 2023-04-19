package cn.ttcxy.entity.model;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class DtsPageView {

    private String pageViewId;

    private String authorId;

    private String dataId;

    private String dataType;

    private String ip;

    private String userAgent;

    private String referer;

    private Date createDate;

    private String title;

    private String createAuthor;
    
}
