package com.ooqn.repository;


import com.ooqn.entity.model.DtsCollect;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DtsCollectRepository extends CrudRepository<DtsCollect, String> {

    long countByDataIdAndAuthorId(String dataId, String authorId);

}
