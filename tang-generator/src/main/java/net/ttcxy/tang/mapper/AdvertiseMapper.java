package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.Advertise;
import net.ttcxy.tang.model.AdvertiseExample;
import org.apache.ibatis.annotations.Param;

public interface AdvertiseMapper {
    long countByExample(AdvertiseExample example);

    int deleteByExample(AdvertiseExample example);

    int deleteByPrimaryKey(String id);

    int insert(Advertise record);

    int insertSelective(Advertise record);

    List<Advertise> selectByExample(AdvertiseExample example);

    Advertise selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Advertise record, @Param("example") AdvertiseExample example);

    int updateByExample(@Param("record") Advertise record, @Param("example") AdvertiseExample example);

    int updateByPrimaryKeySelective(Advertise record);

    int updateByPrimaryKey(Advertise record);
}