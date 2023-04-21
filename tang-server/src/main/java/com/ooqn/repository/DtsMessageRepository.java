package com.ooqn.repository;


import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsMessage;

public interface DtsMessageRepository extends CrudRepository<DtsMessage, String> {

}
