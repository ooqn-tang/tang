package net.ttcxy.tang.gateway.dao.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.entity.model.DtsFavorite;
import net.ttcxy.tang.gateway.entity.model.DtsFavoriteExample;
import org.apache.ibatis.annotations.Param;

public interface DtsFavoriteMapper {
    long countByExample(DtsFavoriteExample example);

    int deleteByExample(DtsFavoriteExample example);

    int deleteByPrimaryKey(String favoriteId);

    int insert(DtsFavorite record);

    int insertSelective(DtsFavorite record);

    List<DtsFavorite> selectByExample(DtsFavoriteExample example);

    DtsFavorite selectByPrimaryKey(String favoriteId);

    int updateByExampleSelective(@Param("record") DtsFavorite record, @Param("example") DtsFavoriteExample example);

    int updateByExample(@Param("record") DtsFavorite record, @Param("example") DtsFavoriteExample example);

    int updateByPrimaryKeySelective(DtsFavorite record);

    int updateByPrimaryKey(DtsFavorite record);
}