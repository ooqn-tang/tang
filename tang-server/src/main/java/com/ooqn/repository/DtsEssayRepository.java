package com.ooqn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.dto.DtsEssayDto;
import com.ooqn.entity.model.DtsEssay;

public interface DtsEssayRepository extends CrudRepository<DtsEssay, String> {


}
