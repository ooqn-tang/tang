package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.model.DtsVbo;

import java.util.List;

public interface DtsVboService {
    int insert(DtsVbo dtsVbo);

    List<DtsVbo> selectVbo(String authorUuid);

    int delete(String uuid);

    int favorite(String uuid);
}
