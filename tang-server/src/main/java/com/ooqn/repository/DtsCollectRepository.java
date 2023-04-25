package com.ooqn.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsCollect;

import jakarta.transaction.Transactional;

@Transactional
public interface DtsCollectRepository extends CrudRepository<DtsCollect, String> {

    /**
     * 根据数据id和作者id删除收藏
     * @param dataId 数据id
     * @param authorId 作者id
     */
    long countByDataIdAndAuthorId(String dataId, String authorId);

    /**
     * 根据数据id和作者id删除收藏
     * @param authorId 作者id
     * @param pageable 分页 
     * @return 收藏列表
     */
    Page<DtsCollect> findByAuthorId(String authorId, Pageable pageable);

}
