package net.ttcxy.tang.dao;

import net.ttcxy.tang.entity.dto.DtsBlogTagDto;
import net.ttcxy.tang.entity.model.DtsBlogTag;

import java.util.List;

public interface DtsBlogTagDao {
    DtsBlogTagDto selectTagBlogCountListByUsername(String tagId , String username);

    List<DtsBlogTagDto> selectTagList();

    List<DtsBlogTagDto> selectTagListByName(String name);

    DtsBlogTagDto selectTagByName(String name);

    List<DtsBlogTagDto> selectAuthorAllTag(String authorId);

    List<DtsBlogTag> selectByBlogId(String blogId);
}
