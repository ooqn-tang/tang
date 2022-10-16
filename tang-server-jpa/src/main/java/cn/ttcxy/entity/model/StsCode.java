package cn.ttcxy.entity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class StsCode {
    
    @Id
    private Integer codeId;

    private String codeName;

    private String codeRemark;

}