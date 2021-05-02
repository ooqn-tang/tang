package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.DtsBlogTagDto;

import java.util.List;

public interface DtsBlogTagDao {
    DtsBlogTagDto selectTagBlogCountListByUsername(String tagId , String username);

    List<DtsBlogTagDto> selectTagList();

    List<DtsBlogTagDto> selectTagListByName(String name);

    List<DtsBlogTagDto> selectAuthorAllTag(String authorId);
}
