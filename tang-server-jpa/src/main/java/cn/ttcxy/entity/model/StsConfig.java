package cn.ttcxy.entity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class StsConfig {
    
    @Id
    private String configId;

    private String configName;

    private String data;

    private Date createDate;

}