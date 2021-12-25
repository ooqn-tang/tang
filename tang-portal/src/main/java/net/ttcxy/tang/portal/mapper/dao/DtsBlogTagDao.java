package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsBlogTagDto;
import net.ttcxy.tang.portal.entity.model.DtsBlogTag;

import java.util.List;

public interface DtsBlogTagDao {
    DtsBlogTagDto selectTagBlogCountListByUsername(String tagId , String username);

    List<DtsBlogTagDto> selectTagList();

    List<DtsBlogTagDto> selectTagListByName(String name);

    DtsBlogTagDto selectTagByName(String name);

    List<DtsBlogTagDto> selectAllTag();

    List<DtsBlogTag> selectByBlogId(String blogId);
}
