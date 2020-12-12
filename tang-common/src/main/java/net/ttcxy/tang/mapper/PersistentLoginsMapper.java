package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.PersistentLogins;
import net.ttcxy.tang.model.PersistentLoginsExample;
import org.apache.ibatis.annotations.Param;

public interface PersistentLoginsMapper {
    long countByExample(PersistentLoginsExample example);

    int deleteByExample(PersistentLoginsExample example);

    int insert(PersistentLogins record);

    int insertSelective(PersistentLogins record);

    List<PersistentLogins> selectByExample(PersistentLoginsExample example);

    int updateByExampleSelective(@Param("record") PersistentLogins record, @Param("example") PersistentLoginsExample example);

    int updateByExample(@Param("record") PersistentLogins record, @Param("example") PersistentLoginsExample example);
}