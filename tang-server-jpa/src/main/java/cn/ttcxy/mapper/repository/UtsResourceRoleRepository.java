package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.UtsResourceRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtsResourceRoleRepository extends CrudRepository<UtsResourceRole, String> {

    void deleteByRoleId(String roleId);
}
