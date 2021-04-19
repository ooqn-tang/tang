package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.UtsGithubLogin;
import net.ttcxy.tang.gateway.model.UtsGithubLoginExample;
import org.apache.ibatis.annotations.Param;

public interface UtsGithubLoginMapper {
    long countByExample(UtsGithubLoginExample example);

    int deleteByExample(UtsGithubLoginExample example);

    int deleteByPrimaryKey(String githubId);

    int insert(UtsGithubLogin record);

    int insertSelective(UtsGithubLogin record);

    List<UtsGithubLogin> selectByExample(UtsGithubLoginExample example);

    UtsGithubLogin selectByPrimaryKey(String githubId);

    int updateByExampleSelective(@Param("record") UtsGithubLogin record, @Param("example") UtsGithubLoginExample example);

    int updateByExample(@Param("record") UtsGithubLogin record, @Param("example") UtsGithubLoginExample example);

    int updateByPrimaryKeySelective(UtsGithubLogin record);

    int updateByPrimaryKey(UtsGithubLogin record);
}