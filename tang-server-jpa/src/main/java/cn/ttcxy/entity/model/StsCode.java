package cn.ttcxy.entity.model;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Entity;

@Entity
@Data
public class StsCode {
    
    @Id
    private Integer codeId;

    private String codeName;

    private String codeRemark;

}