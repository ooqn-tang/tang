package net.ttcxy.tang.db.mapper;

import java.util.List;
import net.ttcxy.tang.entity.model.Advertise;
import net.ttcxy.tang.entity.model.AdvertiseExample;
import org.apache.ibatis.annotations.Param;

public interface AdvertiseMapper {
    long countByExample(AdvertiseExample example);

    int deleteByExample(AdvertiseExample example);

    int insert(Advertise record);

    int insertSelective(Advertise record);

    List<Advertise> selectByExample(AdvertiseExample example);

    int updateByExampleSelective(@Param("record") Advertise record, @Param("example") AdvertiseExample example);

    int updateByExample(@Param("record") Advertise record, @Param("example") AdvertiseExample example);
}