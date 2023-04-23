package com.ooqn.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.StsNotice;

public interface StsNoticeRepository extends CrudRepository<StsNotice, String> {

    List<StsNotice> findAllByOrderByOrderNum();

}
