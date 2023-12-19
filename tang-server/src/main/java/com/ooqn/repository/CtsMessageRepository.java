package com.ooqn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.CtsMessage;

public interface CtsMessageRepository  extends CrudRepository<CtsMessage, String>{

    @Query("FROM CtsMessage WHERE (sendName = ?1 AND acceptName = ?2) or (acceptName = ?1 AND sendName = ?2)")
    List<CtsMessage> findBySendNameAndAcceptName(String username, String memberName);
    
}
