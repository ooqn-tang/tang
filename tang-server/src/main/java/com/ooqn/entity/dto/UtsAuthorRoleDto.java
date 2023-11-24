package com.ooqn.entity.dto;

import java.util.List;

import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtsAuthorRoleDto {
    
    private UtsAuthor author;

    private List<UtsRole> roles;

}
