package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.DtsBlogTagDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlogTag;

import java.util.List;

public interface DtsBlogTagDao {
    DtsBlogTagDto selectTagBlogCountListByUsername(String tagId , String username);

    List<DtsBlogTagDto> selectTagList();

    List<DtsBlogTagDto> selectTagListByName(String name);

    DtsBlogTagDto selectTagByName(String name);

    List<DtsBlogTagDto> selectAuthorAllTag(String authorId);

    List<DtsBlogTag> selectByBlogId(String blogId);
}
