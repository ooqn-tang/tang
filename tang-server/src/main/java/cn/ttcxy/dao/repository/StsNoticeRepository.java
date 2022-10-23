package cn.ttcxy.dao.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.StsNotice;

@Repository
public interface StsNoticeRepository extends JpaRepository<StsNotice, String> {

    @Query("FROM StsNotice ORDER BY orderNum ASC")
    List<StsNotice> findAllOrderByOrderNumAsc();
}