package com.ooqn.entity.dto;

import org.springframework.beans.BeanUtils;

import com.ooqn.entity.model.StsTemplate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StsTemplateDto extends StsTemplate {
    
    public StsTemplateDto(StsTemplate template){
        BeanUtils.copyProperties(template, this);
    }

}
