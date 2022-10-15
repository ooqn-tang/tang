package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class UtsResource {
    
    @Id
    private String resourceId;

    private String path;

    private String name;

    private String type;

    private Date createTime;

    private Integer state;

}