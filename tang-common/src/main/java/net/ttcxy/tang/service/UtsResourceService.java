package net.ttcxy.tang.service;

import net.ttcxy.tang.entity.dto.UtsResourceDto;
import net.ttcxy.tang.entity.model.UtsResource;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsResourceService {
    List<UtsResourceDto> resourceList();

    List<UtsResourceDto> listAll();
}
