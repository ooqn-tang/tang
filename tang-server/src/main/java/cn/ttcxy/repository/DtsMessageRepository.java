package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.dto.DtsMessageDto;
import cn.ttcxy.entity.model.DtsMessage;

public interface DtsMessageRepository extends CrudRepository<DtsMessage, String> {

    @Query(value="""
        select * from dts_message where author_id = ?1
        """,nativeQuery = true)
    List<DtsMessageDto> findAuthorMessage(String authorId);

}
