package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;

public interface DtsEssayRepository extends CrudRepository<DtsEssay, String> {

    @Query(value="select t1.essay_id,t2.author_id from dts_essay t1 , uts_author t2 where t1.author_id and t2.author_id",nativeQuery = true)
    List<DtsEssayDto> findAllInfo();

}
