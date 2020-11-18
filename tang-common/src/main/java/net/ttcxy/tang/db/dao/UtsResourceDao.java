package net.ttcxy.tang.db.dao;

import net.ttcxy.tang.entity.dto.UtsResourceDto;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsResourceDao {
    List<UtsResourceDto> selectResource();
}
