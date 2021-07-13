package net.ttcxy.tang.dao.mapper;

import net.ttcxy.tang.entity.model.PersistentLogins;
import net.ttcxy.tang.entity.model.PersistentLoginsExample;
import org.apache.ibatis.annotations.Param;

public interface PersistentLoginsMapper {
    long countByExample(PersistentLoginsExample example);

    int deleteByExample(PersistentLoginsExample example);

    int deleteByPrimaryKey(String username);

    int insert(PersistentLogins record);

    int insertSelective(PersistentLogins record);

    PersistentLogins selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") PersistentLogins record, @Param("example") PersistentLoginsExample example);

    int updateByExample(@Param("record") PersistentLogins record, @Param("example") PersistentLoginsExample example);

    int updateByPrimaryKeySelective(PersistentLogins record);

    int updateByPrimaryKey(PersistentLogins record);
}