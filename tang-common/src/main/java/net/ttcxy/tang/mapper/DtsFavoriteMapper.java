package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.DtsFavorite;
import net.ttcxy.tang.model.DtsFavoriteExample;
import org.apache.ibatis.annotations.Param;

public interface DtsFavoriteMapper {
    long countByExample(DtsFavoriteExample example);

    int deleteByExample(DtsFavoriteExample example);

    int insert(DtsFavorite record);

    int insertSelective(DtsFavorite record);

    List<DtsFavorite> selectByExample(DtsFavoriteExample example);

    int updateByExampleSelective(@Param("record") DtsFavorite record, @Param("example") DtsFavoriteExample example);

    int updateByExample(@Param("record") DtsFavorite record, @Param("example") DtsFavoriteExample example);
}