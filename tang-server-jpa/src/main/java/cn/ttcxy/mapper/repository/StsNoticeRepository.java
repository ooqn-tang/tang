package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.StsNotice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StsNoticeRepository extends JpaRepository<StsNotice, String> {

    @Query("FROM StsNotice ORDER BY orderNum ASC")
    List<StsNotice> findAllOrderByOrderNumAsc();
}
