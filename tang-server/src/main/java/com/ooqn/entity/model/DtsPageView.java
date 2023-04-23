package com.ooqn.entity.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "页面访问")
public class DtsPageView {

    @Id
    private String pageViewId;

    private String authorId;

    private String dataId;

    private String dataType;

    private String ip;

    private String userAgent;

    private String referer;

    private Date createTime;

    private String title;

    private String createAuthor;
    
}
