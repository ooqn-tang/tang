package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.UtsResourceDto;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsResourceDao {
    List<UtsResourceDto> selectResource();
}
