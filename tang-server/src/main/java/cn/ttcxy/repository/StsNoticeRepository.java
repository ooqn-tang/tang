package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.StsNotice;
import org.springframework.stereotype.Repository;

public interface StsNoticeRepository extends CrudRepository<StsNotice, String> {

    @Query("FROM StsNotice ORDER BY orderNum ASC")
    List<StsNotice> findAllOrderByOrderNumAsc();

    @Query(value = "FROM StsNotice ORDER BY orderNum ASC", nativeQuery = true)
    Integer selectNoticeMaxOrder();
}
