package com.ooqn.entity.dto;

import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.model.UtsAuthor;

import lombok.Data;

@Data
public class DtsSubjectDto {

    private DtsSubject subject;

    private UtsAuthor author;
}
