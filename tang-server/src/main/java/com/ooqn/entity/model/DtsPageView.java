package com.ooqn.entity.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DtsPageView {

    @Id
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
