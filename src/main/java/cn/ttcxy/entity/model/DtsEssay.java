package cn.ttcxy.entity.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DtsEssay implements Serializable {

    private String essayId;

    private String authorId;

    private String text;

    private String url;

    private Date createTime;

    private String coverUrl;

    private static final long serialVersionUID = 1L;

}