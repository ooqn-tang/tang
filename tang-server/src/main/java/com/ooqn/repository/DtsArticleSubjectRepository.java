package com.ooqn.repository;


import java.util.List;

import com.ooqn.entity.dto.DtsArticleSubjectDto;
import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.model.DtsArticleSubject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DtsArticleSubjectRepository extends CrudRepository<DtsArticleSubject, String> {

}
