package com.ooqn.repository;


import java.util.List;

import com.ooqn.entity.dto.DtsMessageDto;
import com.ooqn.entity.model.DtsMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DtsMessageRepository extends CrudRepository<DtsMessage, String> {

}
