package net.ttcxy.tang.admin.dao;

import net.ttcxy.tang.admin.entity.dto.UtsResourceDto;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsResourceDao {
    List<UtsResourceDto> selectResource();
}
