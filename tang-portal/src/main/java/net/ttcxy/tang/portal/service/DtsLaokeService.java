package net.ttcxy.tang.portal.service;

import net.ttcxy.tang.portal.entity.dto.DtsLaokeDto;
import net.ttcxy.tang.portal.entity.model.DtsLaoke;

import java.util.List;

public interface DtsLaokeService {

    Integer insert(DtsLaoke laoke);

    Integer delete(String id);

    List<DtsLaokeDto> loadList();
}
