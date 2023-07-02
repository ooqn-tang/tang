package com.ooqn.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.StsNotice;

public interface StsNoticeRepository extends CrudRepository<StsNotice, String> {

    List<StsNotice> findAllByOrderByOrderNum();

    //随机查询10条数据
    List<StsNotice> findTop10ByOrderByOrderNum();

    //删除两个时间间的数据
    void deleteByCreateTimeBetween(String startTime, String endTime);

    @Query("select max(n.orderNum) from StsNotice n")
    Optional<Integer> findNoticeMaxOrder();


}
