package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.DtsBlogTagDto;

import java.util.List;

public interface DtsBlogTagDao {
    DtsBlogTagDto selectTagBlogListByUsername(String tagId , String username);

    List<DtsBlogTagDto> selectTagList();
}
