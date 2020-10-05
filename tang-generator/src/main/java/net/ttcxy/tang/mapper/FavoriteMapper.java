package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.Favorite;
import net.ttcxy.tang.model.FavoriteExample;
import org.apache.ibatis.annotations.Param;

public interface FavoriteMapper {
    long countByExample(FavoriteExample example);

    int deleteByExample(FavoriteExample example);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    List<Favorite> selectByExample(FavoriteExample example);

    int updateByExampleSelective(@Param("record") Favorite record, @Param("example") FavoriteExample example);

    int updateByExample(@Param("record") Favorite record, @Param("example") FavoriteExample example);
}