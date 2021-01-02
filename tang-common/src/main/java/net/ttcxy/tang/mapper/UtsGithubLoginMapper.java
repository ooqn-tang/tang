package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsGithubLogin;
import net.ttcxy.tang.model.UtsGithubLoginExample;
import org.apache.ibatis.annotations.Param;

public interface UtsGithubLoginMapper {
    long countByExample(UtsGithubLoginExample example);

    int deleteByExample(UtsGithubLoginExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(UtsGithubLogin record);

    int insertSelective(UtsGithubLogin record);

    List<UtsGithubLogin> selectByExample(UtsGithubLoginExample example);

    UtsGithubLogin selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") UtsGithubLogin record, @Param("example") UtsGithubLoginExample example);

    int updateByExample(@Param("record") UtsGithubLogin record, @Param("example") UtsGithubLoginExample example);

    int updateByPrimaryKeySelective(UtsGithubLogin record);

    int updateByPrimaryKey(UtsGithubLogin record);
}