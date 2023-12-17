package com.ooqn.entity.dto;

import org.springframework.beans.BeanUtils;

import com.ooqn.entity.model.DtsRemark;
import com.ooqn.entity.model.UtsAuthor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtsRemarkDto extends DtsRemark {

    public DtsRemarkDto(DtsRemark remark){
        BeanUtils.copyProperties(remark, this);
    }
    
    private UtsAuthor author;
}
