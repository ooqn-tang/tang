package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class UtsFans {
    
    @Id
    private String fansId;

    private String beAuthorId;

    private String authorId;

    private Date createDate;

}