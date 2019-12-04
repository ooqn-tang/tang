package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.Special;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：HuangLei
 * @date ：2019/11/30 0030 21:00
 */
public interface SpecialMapper {

    List<Special> selectSpecial();

    Special specialBlogs(@Param("sid") String sid);



    void insertSpecial(Special special);

}
