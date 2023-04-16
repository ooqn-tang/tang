package cn.ttcxy.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;
import org.springframework.stereotype.Repository;

public interface DtsEssayRepository extends CrudRepository<DtsEssay, String> {

    @Query(value="select * from dts_essay",nativeQuery = true)
    Page<DtsEssayDto> select(Pageable pageable);

}
