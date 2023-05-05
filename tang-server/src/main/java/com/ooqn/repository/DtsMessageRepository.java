package com.ooqn.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsMessage;

public interface DtsMessageRepository extends CrudRepository<DtsMessage, String> {

    List<DtsMessage> findMessageByAuthorId(String authorId);

}
