package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.ResourceDto;

import java.util.List;

/**
 * @author huanglei
 */
public interface ResourceDao {
    List<ResourceDto> selectResource();
}
